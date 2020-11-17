package geohash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class GeoMain {
    public static void main(String args[]) {
        String a = GeoHashUtils.encode(37.400218, 127.112053); //빌딩이름 안보임
        System.out.println(a);
        a = GeoHashUtils.encode(37.400217, 127.112053); //빌딩이름 보임
        System.out.println(a);

        a = GeoHashUtils.encode(37.4002173, 127.112053);
        System.out.println(a);
        a = GeoHashUtils.encode(37.4002175, 127.112053);
        System.out.println(a);
        //37.379034, 127.101472
        //37.332130, 127.142777
        a = GeoHashUtils.encode(37.4002173, 127.112053,7);
        System.out.println(a);
        a = GeoHashUtils.encode(37.40021, 127.111,7);
        System.out.println(a);
        //37.4002173,127.112053/ 37.40021,127.112



//        parseSuggest();
//        parseSuggestPlace();
//        parseAllAddress();
//        parseGetBcode();
//        parseGetCodebyName();


//        int count = 0;
//        HashMap<String, String> geoHash = new HashMap<String, String>();
//        for(double y=37.33213; y<=37.37903; y=y+0.00001) {
//            for(double x=127.10147; x<=127.14277; x=x+0.00001) {
//                geoHash.put(GeoHashUtils.encode(y, x), "A"); //암것도 안넣으면 12가 맞네..
//                count++;
//            }
//        }
//        System.out.println(geoHash.size());
//        System.out.println(count);


    }

    public static void parseGetCodebyName() {
        HashMap<String, String> hash = new HashMap<String, String>();
        int count = 0;
        try {
            //파일 객체 생성
            File file = new File("/Users/scott/Downloads/local_codebyname.txt");
            //스캐너로 파일 읽기
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.isEmpty()) continue;
                hash.put(line, "A");
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(hash.size());
        System.out.println(count);
    }

    public static void parseGetBcode() {
        HashMap<String, String> hash = new HashMap<String, String>();
        int count = 0;
        try {
            //파일 객체 생성
            File file = new File("/Users/scott/Downloads/local_getbcode.txt");
            //스캐너로 파일 읽기
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.isEmpty()) continue;
                hash.put(line, "A");
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(hash.size());
        System.out.println(count);
    }

    public static void parseSuggest() {
        HashMap<String, String> hash = new HashMap<String, String>();
        int count = 0;
        try {
            //파일 객체 생성
            File file = new File("/Users/scott/Downloads/local_s.txt");
            //스캐너로 파일 읽기
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.isEmpty()) continue;
                hash.put(line, "A");
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(hash.size());
        System.out.println(count);
    }

    public static void parseSuggestPlace() {
        HashMap<String, String> geoHash = new HashMap<String, String>();
        int count = 0;
        try {
            //파일 객체 생성
            File file = new File("/Users/scott/Downloads/local_sp.txt");
            //스캐너로 파일 읽기
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.isEmpty()) continue;

                String[] sp = line.split(",");
                if(sp.length != 3) continue;

                geoHash.put(sp[0]+GeoHashUtils.encode(Double.valueOf(sp[1]), Double.valueOf(sp[2])), "A");
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(geoHash.size());
        System.out.println(count);
    }

    public static void parseAllAddress() {
        HashMap<String, String> geoHash = new HashMap<String, String>();
        int count = 0;
        try {
            //파일 객체 생성
            File file = new File("/Users/scott/Downloads/local_allad.txt");
            //스캐너로 파일 읽기
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.isEmpty()) continue;
                double x = Double.valueOf(line.split(",")[0]);
                double y = Double.valueOf(line.split(",")[1]);
                geoHash.put(GeoHashUtils.encode(x, y), "A");
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(geoHash.size());
        System.out.println(count);
    }

}
