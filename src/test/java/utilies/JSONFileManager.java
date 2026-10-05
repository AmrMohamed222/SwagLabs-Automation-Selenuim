package utilies;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;

public class JSONFileManager {
    public LinkedHashMap<String,Object> data;
    public JSONFileManager(String filepath){

        try{
            Type type = new TypeToken<LinkedHashMap<String,Object>>() {}.getType();
            data = new Gson().fromJson(new FileReader(filepath), type);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public Object getValue(String key) {
        return data.get(key);
    }
}
