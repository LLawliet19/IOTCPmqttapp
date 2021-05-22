package com.example.mqttapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static String MQTTHOST = "broker.mqttdashboard.com";
    static String USERNAME = "iotproject";
    static String PASSWORD = "IOTclient";
    String topicStr = "/iot/arm_joint_angles";
    String topicStr1 = "/iot/vaccum_gripper";
    public Spinner spnBin;
    public Spinner spnBox;





    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), "tcp://broker.hivemq.com:1883", clientId);

        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());

        spnBin = findViewById(R.id.Binspin);
        List<String> Bin = new ArrayList<>();
        Bin.add("- Chose your Bin-");
        Bin.add("Default");
        Bin.add("Red");
        Bin.add("Green");
        Bin.add("Yellow");

        spnBox = findViewById(R.id.Boxspin);
        List<String> Box = new ArrayList<>();
        Box.add("- Chose your Box-");
        Box.add("Box 00");
        Box.add("Box 01");
        Box.add("Box 02");
        Box.add("Box 10");
        Box.add("Box 11");
        Box.add("Box 12");
        Box.add("Box 20");
        Box.add("Box 21");
        Box.add("Box 22");


        ArrayAdapter<String> BinAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Bin);
        BinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBin.setAdapter(BinAdapter);

        spnBin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String binSelect = spnBin.getSelectedItem().toString();
                if(binSelect.equals("Default")){
                    String topic = topicStr;

                    final String message1 = "0 -80 0 0 0 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }

                else if (binSelect.equals("Red")){
                    String topic = topicStr;

                    final String message1 = "-14 0 0 0 0 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }
                else if (binSelect.equals("Green")){
                    String topic = topicStr;

                    final String message1 = "70 0 0 0 0 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                else if(binSelect.equals("Yellow")){
                    String topic = topicStr;

                    final String message1 = "154 0 0 0 0 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> BoxAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Box);
        BoxAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBox.setAdapter(BoxAdapter);


        spnBox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String boxSelect = spnBox.getSelectedItem().toString();
                if (boxSelect.equals("Box 00")){
                    String topic = topicStr;

                    final String message1 = "-53 -84 43 -139 -128 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }

                if (boxSelect.equals("Box 01")){
                    String topic = topicStr;

                    final String message1 = "-125 -104 62 -138 -56 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }

                if (boxSelect.equals("Box 02")){
                    String topic = topicStr;

                    final String message1 = "-160 -86 46 -141 -22 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }

                if (boxSelect.equals("Box 10")){
                    String topic = topicStr;

                    final String message1 = "-53 -90 60 27 128 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }

                if (boxSelect.equals("Box 11")){
                    String topic = topicStr;

                    final String message1 = "120 -62 -112 -6 59 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }

                if (boxSelect.equals("Box 12")){
                    String topic = topicStr;

                    final String message1 = "56 -82 -100 1 122 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }

                if (boxSelect.equals("Box 20")){
                    String topic = topicStr;

                    final String message1 = "-54 -95 102 -7 127 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }

                if (boxSelect.equals("Box 21")){
                    String topic = topicStr;

                    final String message1 = "-118 -118 119 0 63 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }

                if (boxSelect.equals("Box 22")){
                    String topic = topicStr;

                    final String message1 = "-159 -100 107 -7 22 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button GripON = (Button)findViewById(R.id.Pick);
        Button GripOFF = (Button)findViewById(R.id.place);

        GripON.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String boxSelect = spnBox.getSelectedItem().toString();

                if (boxSelect.equals("Box 00")){
                    String topic = topicStr1;
                    final String message1 = "0 0 1";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }

                if (boxSelect.equals("Box 01")){
                    String topic = topicStr1;
                    final String message1 = "0 1 1";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 02")){
                    String topic = topicStr1;
                    final String message1 = "0 2 1";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 10")){
                    String topic = topicStr1;
                    final String message1 = "1 0 1";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 11")){
                    String topic = topicStr1;
                    final String message1 = "1 1 1";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 12")){
                    String topic = topicStr1;
                    final String message1 = "1 2 1";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 20")){
                    String topic = topicStr1;
                    final String message1 = "2 0 1";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 21")){
                    String topic = topicStr1;
                    final String message1 = "2 1 1";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 22")){
                    String topic = topicStr1;
                    final String message1 = "2 2 1";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        GripOFF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String boxSelect = spnBox.getSelectedItem().toString();

                if (boxSelect.equals("Box 00")){
                    String topic = topicStr1;
                    final String message1 = "0 0 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }

                if (boxSelect.equals("Box 01")){
                    String topic = topicStr1;
                    final String message1 = "0 1 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 02")){
                    String topic = topicStr1;
                    final String message1 = "0 2 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 10")){
                    String topic = topicStr1;
                    final String message1 = "1 0 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 11")){
                    String topic = topicStr1;
                    final String message1 = "1 1 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 12")){
                    String topic = topicStr1;
                    final String message1 = "1 2 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 20")){
                    String topic = topicStr1;
                    final String message1 = "2 0 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 21")){
                    String topic = topicStr1;
                    final String message1 = "2 1 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
                if (boxSelect.equals("Box 22")){
                    String topic = topicStr1;
                    final String message1 = "2 2 0";

                    String message = message1;
                    try {
                        client.publish(topic, message.getBytes(),0,false);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }
            }
        });






        try {
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Toast.makeText(MainActivity.this,"Connetcted", Toast.LENGTH_LONG).show();
                    // We are connected

                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Toast.makeText(MainActivity.this,"Connection Failed", Toast.LENGTH_LONG).show();
                    // Something went wrong e.g. connection timeout or firewall problems


                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void pub(View V){
        String topic = topicStr;
        final EditText messagesend = (EditText) findViewById(R.id.send);
        final String message1 = messagesend.getText().toString();

        String message = message1;
        try {
            client.publish(topic, message.getBytes(),0,false);
        } catch (MqttException e) {
            e.printStackTrace();
        }



    }

}