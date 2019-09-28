package APIs;

public class Authentication {
    //@JsonProperty("access_token")
    private String access_token;
    //@JsonProperty("expires_in")
    private int expires_in;
    //@JsonProperty("token_type")
    private String token_type;

    Authentication()
    {

    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }
}