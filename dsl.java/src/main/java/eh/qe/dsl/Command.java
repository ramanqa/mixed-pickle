package eh.qe.dsl;

public interface Command{

    public String getLanguage();
    public String getAction();
    public String[] getParamsArray();
    public Map<String, Object> getParamsMap();

}
