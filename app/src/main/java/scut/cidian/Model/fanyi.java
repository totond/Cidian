package scut.cidian.Model;
import java.util.List;

public class fanyi {
    public String[] translation;
    public basic basic;
    public  static class basic{
        public String phonetic;
        public String[] explains;
    }
    public String query;
    public int errorCode;
    public List<wb> web;
    public static class wb{
            public String[] value;
            public String key;
        }

}



