package com.api.search;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SearchService {
    public SearchService() {}

    public void searchMovies(HttpServletRequest request, HttpServletResponse response) {
        String query = request.getParameter("query");
        String strUrl = "https://api.themoviedb.org/3/search/movie?api_key=a3c86039155edf82ed435e2be619b8a3&language=ko-KR&include_adult=false&query=";
        strUrl += query;
        try {
            URL url = new URL(strUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
            con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정

            con.setRequestMethod("GET");

            /*
             * URLConnection에 대한 doOutput 필드값을 지정된 값으로 설정한다.
             * URL 연결은 입출력에 사용될 수 있다.
             * URL 연결을 출력용으로 사용하려는 경우 DoOutput 플래그를 true로 설정하고, 그렇지 않은 경우는 false로 설정해야 한다.
             * 기본값은 false이다.
             */
            con.setDoOutput(false);

            StringBuilder sb = new StringBuilder();
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                br.close();
                System.out.println("" + sb.toString());
                JsonParser jsonParser = new JsonParser();
                JsonArray resultArray = jsonParser.parse(sb.toString()).getAsJsonObject().getAsJsonArray("results");
                System.out.println(resultArray.get(0).getAsJsonObject().get("genre_ids").getAsJsonArray().get(2).toString());

            } else {
                System.out.println(con.getResponseMessage());
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
