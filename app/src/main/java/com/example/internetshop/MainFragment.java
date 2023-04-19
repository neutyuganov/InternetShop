package com.example.internetshop;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainFragment extends Fragment {

    Button cpu;
    Button motherboard;
    Button gpu;
    Button rom;
    ListView listView;
    JSONArray array;
    JSONObject object;
    List<String> items = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);


        cpu = v.findViewById(R.id.cpu);
        motherboard = v.findViewById(R.id.motherboard);
        gpu = v.findViewById(R.id.gpu);
        rom = v.findViewById(R.id.rom);
        listView = v.findViewById(R.id.listView);


        new Thread(new Runnable() {
            public void run() {
                try {
                    String content = getContent("https://117c-89-113-140-10.ngrok-free.app/api/%D0%A2%D0%BE%D0%B2%D0%B0%D1%80");
                    JSONObject root = new JSONObject(content);
                    JSONObject response = root.getJSONObject("data");
                    array= response.getJSONArray("memes");

                    listView.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                ArrayList<JSONObject> listItems = getArrayListFromJSONArray(array);
                                MainFAdapter adapter = new MainFAdapter(v.getContext(),R.layout.list_item_cart,listItems);
                                // Присваиваем ListView созданный адаптер
                                if (listView != null) {
                                    listView.setAdapter(adapter);
                                }
                            } catch (Exception e) { //JSONException
                                throw new RuntimeException(e);
                            }
                        }
                    });

                } catch (IOException ex) {

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
    }).start();

        Drawable drawableT = getResources().getDrawable(R.drawable.button_change_t);
        Drawable drawableF = getResources().getDrawable(R.drawable.button_change_f);
        Color colorW = Color.valueOf(getResources().getColor(R.color.secondary_text));

        cpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 cpu.setBackground(drawableT);
                 cpu.setTextColor(getResources().getColor(R.color.white));

                 motherboard.setBackground(drawableF);
                 motherboard.setTextColor(getResources().getColor(R.color.secondary_text));
                 gpu.setBackground(drawableF);
                 gpu.setTextColor(getResources().getColor(R.color.secondary_text));
                 rom.setBackground(drawableF);
                 rom.setTextColor(getResources().getColor(R.color.secondary_text));
            }
        });

        motherboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                motherboard.setBackground(drawableT);
                motherboard.setTextColor(getResources().getColor(R.color.white));

                cpu.setBackground(drawableF);
                cpu.setTextColor(getResources().getColor(R.color.secondary_text));
                gpu.setBackground(drawableF);
                gpu.setTextColor(getResources().getColor(R.color.secondary_text));
                rom.setBackground(drawableF);
                rom.setTextColor(getResources().getColor(R.color.secondary_text));
            }
        });

        gpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gpu.setBackground(drawableT);
                gpu.setTextColor(getResources().getColor(R.color.white));

                cpu.setBackground(drawableF);
                cpu.setTextColor(getResources().getColor(R.color.secondary_text));
                motherboard.setBackground(drawableF);
                motherboard.setTextColor(getResources().getColor(R.color.secondary_text));
                rom.setBackground(drawableF);
                rom.setTextColor(getResources().getColor(R.color.secondary_text));
            }
        });

        rom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rom.setBackground(drawableT);
                rom.setTextColor(getResources().getColor(R.color.white));

                cpu.setBackground(drawableF);
                cpu.setTextColor(getResources().getColor(R.color.secondary_text));
                motherboard.setBackground(drawableF);
                motherboard.setTextColor(getResources().getColor(R.color.secondary_text));
                gpu.setBackground(drawableF);
                gpu.setTextColor(getResources().getColor(R.color.secondary_text));
            }
        });

        return v;

    }
    private ArrayList<JSONObject> getArrayListFromJSONArray(JSONArray jsonArray){
        ArrayList<JSONObject> aList = new ArrayList<>();
        try {
            if(jsonArray!= null){
                for(int i = 0; i< jsonArray.length();i++){
                    aList.add(jsonArray.getJSONObject(i));
                }
            }
        }catch (JSONException js){
            js.printStackTrace();
        }
        return aList;
    }


    private String getContent(String path) throws IOException {
        // Для буферизации текста из потока
        BufferedReader reader=null;
        // Байтовый поток для записи
        InputStream stream = null;
        // Вызываем класс для для реализации работы с сетью
        HttpsURLConnection connection = null;
        try {
            // Присваиваем путь
            URL url=new URL(path);
            connection =(HttpsURLConnection)url.openConnection();
            // Выбираем метод GET для запроса
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.connect();
            // Полученный результат разбиваем с помощью байтовых потоков
            stream = connection.getInputStream();
            reader= new BufferedReader(new InputStreamReader(stream));
            StringBuilder buf=new StringBuilder();
            String line;
            while ((line=reader.readLine()) != null) {
                buf.append(line).append("\n");
            }
            // Возвращаем разбитый по строкам результат
            return(buf.toString());
        }
        // Закрываем открытые потоки и подключения
        finally {
            if (reader != null) {
                reader.close();
            }
            if (stream != null) {
                stream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}