package Permission;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import org.openqa.selenium.devtools.v136.network.Network;
import Base_Package.Base_Class;
 


public class Permission extends Base_Class{
	public boolean  Is_Super_Admin;
	public boolean  Is_Admin;
	String token;
	String jsonResponse;

	public void SessionFetch() throws Exception {
		
	    BlockingQueue<String> tokenQueue = new ArrayBlockingQueue<>(1);

	    devTools.addListener(Network.responseReceived(), response -> {
	        String url = response.getResponse().getUrl();

	        if (url.contains("/api/auth/session")) {
	            Network.GetResponseBodyResponse bodyResponse =
	                devTools.send(Network.getResponseBody(response.getRequestId()));
	             jsonResponse = bodyResponse.getBody();
	            tokenQueue.offer(jsonResponse);
	        }
	    });
	    
	    String sessionJson = tokenQueue.poll(10, TimeUnit.SECONDS);
	    
	    Thread.sleep(1000);
        JSONObject obj = new JSONObject(sessionJson);
        JSONObject userObj = obj.getJSONObject("user");
        
        token = userObj.getString("token");
        Is_Super_Admin = userObj.getBoolean("is_super_admin");
        Is_Admin = userObj.getBoolean("is_admin");
         }
	
	
	public boolean User_Permission_Check(String ModuleName, String Action) throws Exception {
			
			SessionFetch() ;
			
			if (Is_Admin) {
				 System.out.println("✅ The User is a Admin : " + Is_Admin);
				 return true;
				}
			else if (Is_Super_Admin) {
				System.out.println("✅ The User is a Super Admin : " + Is_Super_Admin);
				 return true;
				 }
			else { Response rp = given()
		                        	.header("Authorization", "Bearer " + token)
		                        .when()
		                        	.get("https://api-qa.bidplan.aptagrim.co/permissions/api/v1/logged-in-user-permission-api/");

				        List<Map<String, Object>> results = rp.jsonPath().getList("results");

				        for (Map<String, Object> module : results) {
				            String moduleTitle = (String) module.get("title");

				            if (moduleTitle.equals(ModuleName)) {
				                List<Map<String, Object>> subPermissions = (List<Map<String, Object>>) module.get("sub_permissions");

				                for (Map<String, Object> subPerm : subPermissions) {
				                    String subTitle = (String) subPerm.get("title");

				                    if (subTitle.equals(Action)) {
				                        Boolean hasPermission = (Boolean) subPerm.get("has_permission");

				                        if (hasPermission) {
				                            System.out.println("✅ The User Has Permission For the : " + Action);
				                            return true;
				                        } else {
				                            System.out.println("❌ The User Has Does Not Have Permission For the: " + Action);
				                            System.out.println("⏩ Skipping test");
				                            return false;
				                        }
				                    }
				                }
				            }
				        }
					}
	         
			
			 return false;
		}
	
	}
