package wili_be.controller.status;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
public class ApiResponse {
    private String status;
    private Map<String, Object> data = new HashMap<>();
    private String message;


    public void addStatus(String s) {
        this.status = s;
    }
    public void addMessage(String m) {
        this.message = m;
    }

    public void addData_WithOutTitle(Map<String, Object> data) {
        this.data = data;
    }
    public void addNullData() {
        this.data = null;
    }


    //  /user/auth
    public void success_user_auth(String snsId) {
        addStatus("true");
        Map<String, Object> new_data = new HashMap<>();
        new_data.put("snsId", snsId);
        addData_WithOutTitle(new_data);
        addMessage("Authentication success");
    }

    //  /user/refresh-token
    public void success_user_refresh_Token(String snsId) {
        addStatus("true");
        Map<String, Object> new_data = new HashMap<>();
        new_data.put("snsId", snsId);
        addData_WithOutTitle(new_data);
        addMessage("token refresh success");
    }
    public void fail_user_refresh_Token() {
        addStatus("fail");
        addNullData();
        addMessage("token refresh failed");
    }

    // kakao & naver callback
    public void success_oauth_login(Object memberInfo) {
        addStatus("true");
        Map<String, Object> new_data = new HashMap<>();
        new_data.put("member_info", memberInfo);
        addData_WithOutTitle(new_data);
        addMessage("Login success");
    }
    public void fail_oauth_login() {
        addStatus("false");
        addMessage("Login failed");
        addNullData();
    }

    // user/logout
    public void success_user_logout() {
        addStatus("success");
        addMessage("Logout success");
        addNullData();
    }

    // /users/{snsId}
    public void success_user_getInfo(Object o) {
        addStatus("success");
        addMessage("user info look up success");
        Map<String, Object> new_data = new HashMap<>();
        new_data.put("member_Info", o);
        addData_WithOutTitle(new_data);
    }

    // PATCH user/{snsId}
    public void success_user_editInfo(Object o) {
        addStatus("success");
        addMessage("user info edit success");
        Map<String, Object> new_data = new HashMap<>();
        new_data.put("member_Info", o);
        addData_WithOutTitle(new_data);
    }

    //DELETE user/{snsId}
    public void success_user_delete() {
        addStatus("success");
        addNullData();
        addMessage("withdraw success");
    }
    public void fail_user_delete() {
        addStatus("fail");
        addNullData();
        addMessage("withdraw failed");
    }
}
