import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Loadd {
    List<String> myList = new ArrayList<>();
    List<Integer> myListS = new ArrayList<>();
    ArrayList<Players> records = new ArrayList<>();
    public class Players {
        String name;
        String surname;
        String team;
        String salar;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getSurname() {
            return surname;
        }
        public void setSurname(String surname) {
            this.surname = surname;
        }
        public String getTeam() {
            return team;
        }
        public void setTeam(String team) { this.team = team; }
        public String getSalar() {
            return salar;
        }
        public void setSalar(String salar) { this.salar = salar; }
    }

    public void lo (String lokalizacja) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(lokalizacja))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Players playerobj = new Players();
                playerobj.setName(values[0]);
                playerobj.setSurname(values[1]);
                playerobj.setTeam(values[8]);
                playerobj.setSalar(values[26]);
                records.add(playerobj);

                //System.out.println(values[0]);

            }
        }
        /*for (Players obj: records) {
            System.out.println(obj.getName()+ " " + obj.getSurname()+ " " + obj.getTeam()+ " " + obj.getSalar());
        }*/
    }

            public void wstaw (String nazwadruzyny,String pathh) throws IOException {
                //lo("C:/Users/MICRON PRO/IdeaProjects/TM/RS.csv");
                lo(pathh);
                String nd = nazwadruzyny;
                for (Players obj: records) {
                    nazwadruzyny=obj.getTeam();
                    if (nazwadruzyny.equals(nd)) {
                        String number = obj.getSalar();
                        double amount = Double.parseDouble(number);
                        DecimalFormat formatter = new DecimalFormat("#,###");
                        //System.out.println(formatter.format(amount));
                        myList.add(obj.getName()+ " " + obj.getSurname()+" " + formatter.format(amount));
                        myListS.add(Integer.parseInt(obj.getSalar()));
                        //System.out.println(Integer.parseInt(obj.getSalar()));
                        //System.out.println(obj.getName() + " " + obj.getSurname() + " " + obj.getTeam() + " " + obj.getSalar());
                    }
                    }
            }
}
