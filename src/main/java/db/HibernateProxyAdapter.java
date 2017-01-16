package db;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.hibernate.proxy.HibernateProxy;

import java.io.IOException;

/**
 * Created by Yafei on 13/01/2017.
 */
public class HibernateProxyAdapter extends TypeAdapter<HibernateProxy> {

    @Override
    public void write(JsonWriter jsonWriter, HibernateProxy hibernateProxy) throws IOException {

    }

    @Override
    public HibernateProxy read(JsonReader jsonReader) throws IOException {
        return null;
    }
}
