package com.javaminds;





import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.net.*;

class Test
{

    private boolean sendGCM( String deviceId , String data) throws Exception{
        boolean sendStatus = false;
        try{
            final String USER_AGENT = "Mozilla/5.0";
            URL obj = new URL("https://fcm.googleapis.com/fcm/send");
//            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

            HttpURLConnection conn = null;

//          SocketAddress proxyAddress = new InetSocketAddress("192.168.127.10", 3128);
//          Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddress);
//          conn = (HttpURLConnection)obj.openConnection(proxy);

            conn = (HttpURLConnection) obj.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", USER_AGENT);
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "key=AAAANL-ZE_4:APA91bGpAn8-iEmDEGZtGPAneCXgDsA36WzE_sj4gCxKyY6muYpg6OlUWgfaH2vk27-yMIB9yBd2nDDIArh-Yg-WfOkf8vDhPdgW7Ri1Dv8blF1_851QO3sVBdhdu35ix1r4hw5XxCsr");
            conn.setDoOutput(true);
            String strResponseText = "";


            conn.setConnectTimeout(2000);
            PrintWriter printwriter = new PrintWriter(conn.getOutputStream());
            printwriter.println(data);
            printwriter.close();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String s1;
            while((s1 = bufferedreader.readLine()) != null){
                strResponseText = (new StringBuilder()).append(strResponseText).append(s1).toString();
            }
            bufferedreader.close();

//            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println(strResponseText+"\nSending 'POST' request to URL : " + conn.getResponseCode());

        }catch (Exception e) {
            System.out.println("e3 = " + e);
            e.printStackTrace();
        }
        return sendStatus;
    }

    public static  void main(String args[]){
        try{
            Test obj = new Test();
            //obj.callToken("A H PARKAR","WNS0000059306","0");
            String s="{\n" +
                    "    \"to\": \"egPEtj-gTgOIZgutQayEXc:APA91bFcOMbSOWslfVhj_stnPZbwvHVyGhsXwVUYzs_3I3ALzuSDCZMzFc_BqxRvxwFbNAPfnAi13mCI23i8Ee30ocbw4i31tpskIrfjp5Yjg1zAZj142Fu4DySd82KPmj9-l24UKLH2\",\n" +
                    "    \"priority\": \"high\",\n" +
                    "    \"data\":  {\n" +
                    "                \"header\": [\n" +
                    "                    {\n" +
                    "                        \"label\": \"Mobile NO\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"label\": \"Token No\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"label\": \"Counter\"\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"data\": [\n" +
                    "                    {\n" +
                    "                        \"mobileNO\": \"9978678768\",\n" +
                    "                        \"tokenNo\": \"T67788\",\n" +
                    "                        \"counter\": \"C00001\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"mobileNO\": \"9978678768\",\n" +
                    "                        \"tokenNo\": \"T67788\",\n" +
                    "                        \"counter\": \"C00001\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"mobileNO\": \"9978678768\",\n" +
                    "                        \"tokenNo\": \"T67788\",\n" +
                    "                        \"counter\": \"C00001\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"mobileNO\": \"9978678768\",\n" +
                    "                        \"tokenNo\": \"T67788\",\n" +
                    "                        \"counter\": \"C00001\"\n" +
                    "                    } \n" +
                    "                ],\n" +
                    "                \"Videos\": [\n" +
                    "                    {\n" +
                    "                        \"id\": \"v1\",\n" +
                    "                        \"Videourl\": \"https://www.appsloveworld.com/wp-content/uploads/2018/10/Sample-Mp4-Videos.mp4\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"id\": \"v2\",\n" +
                    "                        \"Videourl\": \"https://s3.amazonaws.com/freestock-transcoded-videos-prod/transcoded/freestock_v2529101.mp4\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"id\": \"v3\",\n" +
                    "                        \"Videourl\": \"https://media.istockphoto.com/videos/electric-and-futuristic-counter-counting-down-from-ten-to-zero-in-10-video-id904867362\"\n" +
                    "                    }\n" +
                    " \n" +
                    "                ],\n" +
                    "                \"Images\": [\n" +
                    "                    {\n" +
                    "                        \"imgURL\": \"https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455_960_720.jpg\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"imgURL\": \"https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823_960_720.jpg\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"imgURL\": \"https://cdn.pixabay.com/photo/2015/09/09/16/05/forest-931706_960_720.jpg\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"imgURL\": \"https://cdn.pixabay.com/photo/2012/08/06/00/53/bridge-53769_960_720.jpg\"\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"imgURL\": \"https://cdn.pixabay.com/photo/2016/02/13/12/26/aurora-1197753_960_720.jpg\"\n" +
                    "                    }\n" +
                    "                ]\n" +
                    "            }\n" +
                    "}";

            System.out.println("s = " + s);

            obj.sendGCM("",s);
        }catch(Exception e){
            System.out.println("e = " + e);
        }

    }
}