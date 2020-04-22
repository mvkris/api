package less5;

public class TrelloList {

    private String name;
    private String id;
    private String key = "a6aec281ebf7db2a51b09d127177a864";
    private String token = "4d74700253acd9aa363ba945f5007a1da0e919d7d1b3264cb40bbcd1915baca5";

    public String getKey() {
        return key;
    }

    public String getToken() {
        return token;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
}
