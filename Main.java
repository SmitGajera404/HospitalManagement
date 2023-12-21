import java.util.*;
import java.sql.*;
import java.util.Date;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        HospitalManagementSystem h = new HospitalManagementSystem();
        h.setCon();
        h.setMap();
        System.out.println("IF YOU ARE STAFF MEMBER THEN ENTER 1 IF YOU ARE DOCTOR ENTER 2\n");
        int type = sc.nextInt();
        if (type == 1) {
            boolean b = true;
            while (b) {
                System.out.println("WHICH OF THE FOLLOWING OPERATIONS YOU WOULD LIKE TO PERFORM\n");

                //following for loops are performed just for better design

                System.out.println();
                for (int i = 0; i < 170; i++) {
                    System.out.print("_");
                }

                System.out.print("1.ADMIT A PATIENT\t\t\t\t\t|");
                System.out.print("2.BOOK THE APPOINTMENT\t\t\t\t\t|");
                System.out.print("3.ALLOTE THE ROOM\t\t\t\t\t|");
                System.out.println("4.UPDATE PATIENT STATUS\t\t\t\t\t\t    \t|");

                for (int i = 0; i < 170; i++) {
                    System.out.print("_");
                }
                System.out.println();
                System.out.print("5.MANUAL CONTROL TO DATABASE\t\t\t\t\t|");
                System.out.print("6.SEARCH ADMITTED PATIENT\t\t\t\t\t|");
                System.out.print("7.MAKE THE BILL WITH PRECECRIPTIONS\t\t\t\t\t|");
                System.out.println("8.EXIT\t\t\t\t|");
                for (int i = 0; i < 170; i++) {
                    System.out.print("_");
                }

                System.out.println();
                int choice=0;
                while(true) {
                    try {
                        choice = sc.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Enter Valid Input");
                    }
                }
                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.println("ENTER THE NAME OF THE PATIENT");
                        String name = sc.nextLine();
                        System.out.println("ENTER THE MOBILE NUMBER OF PATIENT");
                        String mono = sc.nextLine();
                        System.out.println("ENTER THE D.O.B IN FORMAT OF yyyy-mm-dd");
                        java.sql.Date dob=null;
                        while(true) {
                            try {
                                 dob = java.sql.Date.valueOf(sc.nextLine());
                                break;
                            } catch (Exception e) {
                                System.out.println("Enter Valid Format Of Date");
                            }
                        }
                        boolean admitstatus = true;
                        Patient p = new Patient(name, admitstatus, mono, dob, null);
                        for (int i = 0; i < 211; i++) {
                            System.out.print("_");
                        }
                        h.addPatient(p);
                        break;
                    case 2:
                        System.out.println("Select doctor_id Corresponding to their name");
                        System.out.println("\"1.DR.Pratik Sharma\"\n" +
                                "\"2.DR.John Kennedy\"\n" +
                                "\"3.DR.Kalpesh Trivedi\"\n" +
                                "\"4.DR.Neha Patel\"\n" +
                                "\"5.DR.Hardik Saxena\"");
                        int d_id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Patient Name");
                        String name1 = sc.nextLine();
                        System.out.println("Enter Patient Number");
                        String number = sc.nextLine();
                        System.out.println("Enter Patient Age");
                        int age = sc.nextInt();
                        Time timings = h.setTimings(d_id);
                        if (timings != null) {
                            h.setAppointment(new Appointment(name1, age, timings, number, d_id), d_id);
                        } else {
                            System.out.println("Appointments are Full");
                        }
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("Enter The Patient Name For Alloting Room");
                        h.provideRoom(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("1.Update Admitted Patient Details");
                        switch (sc.nextInt()) {
                            default:
                                System.out.println("Enter Valid Choice Next TIme!!!");
                                break;
                            case 1:
                                System.out.println("1.Update Name");
                                System.out.println("2.Update Mobile Number");
                                System.out.println("3.Update Date Of Birth");
                                switch (sc.nextInt()) {
                                    case 1:
                                        sc.nextLine();
                                        System.out.println("Enter Patient Name");
                                        String oldName = sc.nextLine();
                                        System.out.println("Enter new Name");
                                        String newName = sc.nextLine();
                                        h.updatePatientDetails(oldName, newName);
                                        break;
                                    case 2:
                                        sc.nextLine();
                                        System.out.println("Enter Patient Name");
                                        String oldName1 = sc.nextLine();
                                        System.out.println("Enter new Mobile Number");
                                        String mobile = sc.nextLine();
                                        h.updatePatientDetails(oldName1, mobile, null);
                                        break;
                                    case 3:
                                        sc.nextLine();
                                        System.out.println("Enter Patient Name");
                                        String oldName2 = sc.nextLine();
                                        System.out.println("Enter New DOB");
                                        Date d = java.sql.Date.valueOf(sc.nextLine());
                                        h.updatePatientDetails(oldName2, d);
                                        break;
                                }
                                break;
                        }
                        break;
                    case 5:
                        sc.nextLine();
                        System.out.println("Enter Your Manual Query");
                        h.manualQuery(sc.nextLine());
                        break;
                    case 6:
                        sc.nextLine();
                        System.out.println("Enter Patient Name For Searching");
                        String nameForSearch = sc.nextLine();
                        h.searchPatient(nameForSearch);
                        break;
                    case 7:
                        sc.nextLine();
                        System.out.println("Enter Patient Name For Making Bill");
                        String nameForBill=sc.nextLine();
                        sc.nextInt();
                        System.out.println("Enter Total Expance");
                        int exp=sc.nextInt();
                        h.makeBill(nameForBill,exp);
                        break;
                    case 8:
                        System.exit(0);
                }
            }
        } else {
            int userid = 0;
            do {
                System.out.println("Enter Your User ID");
                try {
                    userid = sc.nextInt();
                }
                catch (Exception e)
                {
                    System.out.println("User Id Is In INTEGER");
                }
            } while (!h.checkId(userid));
            while (true) {
                System.out.println();
                for (int i = 0; i < 170; i++) {
                    System.out.print("_");
                }
                System.out.println();
                System.out.print("1.SEND THE PRECECRIPTION TO THE RECEPTION.          |");
                System.out.print("2.TAKE A LEAVE         |");
                System.out.print("3.COMEBACK TO WORK        |");
                System.out.print("4.CHECK YOUR APPOINTMENTS  |");
                System.out.print("5.DISCHARGE PATIENT       |");
                System.out.print("6.EXIT      |");
                System.out.println();
                for (int i = 0; i < 170; i++) {
                    System.out.print("_");
                }
                System.out.println();
                int choice=0;
                while(true) {
                    try {
                         choice = sc.nextInt();
                         break;
                    } catch (Exception e) {
                        System.out.println("Enter Valid Input");
                    }
                }
                switch (choice) {
                    case 1:
                        System.out.println("Enter name");
                        String nameForMedicine = sc.next();
                        if (h.existsPatient(nameForMedicine)) {
                            int medicineCount = 0;
                            ArrayList<String> medicine = new ArrayList<>();
                            String med = "";
                            while (!med.equals("exit")) {
                                System.out.println("Enter Medicine Number " +( medicineCount + 1));
                                med = sc.next();
                                medicine.add(med);
                                medicineCount++;
                            }
                            medicine.remove("exit");
                            h.sendMedicines(nameForMedicine, medicine);
                        } else {
                            System.out.println("Patient Does Not Exists In System");
                        }
                        break;
                    case 2:
                        h.leave();
                        break;
                    case 3:
                        h.comeback();
                        break;
                    case 4:
                        h.checkAppointments();
                        break;
                    case 5:
                        sc.nextLine();
                        System.out.println("Enter Patient name For Discharging");
                        String nameForDischarging = sc.nextLine();
                        h.dischargePatient(nameForDischarging);
                        break;
                    case 6:
                        System.exit(0);
                        break;
                }
            }
        }
    }
}

class Patient {
    String name;
    boolean admitStatus;
    String mobile;
    Date dob;
    String allotedRoom;

    public Patient(String name, boolean admitStatus, String mobile, Date dob, String allotedRoom) {
        this.name = name;
        this.admitStatus = admitStatus;
        this.mobile = mobile;
        this.dob = dob;
        this.allotedRoom = allotedRoom;
    }
}

class Appointment {

    String name;
    int age;
    Time timings;
    String number;
    int d_id;

    public Appointment(String name, int age, Time timings, String number, int d_id) {
        this.name = name;
        this.age = age;
        this.timings = timings;
        this.number = number;
        this.d_id = d_id;
    }
}

class HospitalManagementSystem {
    HashMap<Integer, Patient> pDetails = new HashMap<>();
    HashMap<Integer, Appointment> aDetails = new HashMap<>();
    Connection con;
    PreparedStatement ps;

    void setCon() throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/HospitalDB", "postgres", "Smit_2824");
        this.con = con;
    }

    boolean existsPatient(String name) throws Exception {

        ps = con.prepareStatement("select p_name from patient where p_name=?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }

    }
    void manualQuery(String sql) throws Exception
    {
        ps=con.prepareStatement(sql);
        boolean b=false;
        ResultSet rs=null;
        try{
            rs=ps.executeQuery();
        }catch (Exception e)
        {
            b=true;
        }
        if(!b)
        {
            ResultSetMetaData rsmt= ps.getMetaData();
            while (rs.next()) {
                for (int i = 0; i < rsmt.getColumnCount(); i++) {
                    System.out.println(rsmt.getColumnName(i+1)+": "+rs.getString(i+1));
                }
                System.out.println("---------------------------------------");
            }
        }
        else{
            if(ps.executeUpdate()!=-1)
            {
                System.out.println("Manipulation SuccessFull!!");
            }
        }
    }

    Time setTimings(int d_id) throws Exception {
        ps = con.prepareStatement("select appointment_count,f_timing,l_timing from doctor where d_id=?");
        ps.setInt(1, d_id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        Time t1 = rs.getTime(2);
        if (count < 6) {
            ps = con.prepareStatement("insert into dummyTime(time) values(?)");
            ps.setTime(1, t1);
            ps.executeUpdate();
            ps = con.prepareStatement("update dummyTime set time=time+interval '" + count * 20 + " minutes' where id=(select max(id) from dummyTime)");
            ps.executeUpdate();
            ps = con.prepareStatement("select time from dummyTime order by id desc limit 1");
            ResultSet rs1 = ps.executeQuery();
            rs1.next();
            return rs1.getTime(1);
        } else {
            return null;
        }
    }

    void checkAppointments() throws Exception {
        Collection <Appointment>c=aDetails.values();
        Set <Integer>s=aDetails.keySet();
        Iterator itr1=s.iterator();
        Iterator itr2=c.iterator();
        int flag=0;
        ps=con.prepareStatement("select * from appointment");
        ResultSet rs=ps.executeQuery();
        while(rs.next()) {
            if(rs.getInt("d_id")==doc_id && rs.getBoolean("status"))
            {
                System.out.println("Appointment_id: "+rs.getInt("ap_id"));
                System.out.println("Name: "+rs.getString("ap_name"));
                System.out.println("Mobile Number: "+rs.getString("ap_number"));
                System.out.println("Age: "+rs.getInt("ap_age"));
                System.out.println("Timings: "+rs.getTime("timings"));
                System.out.println("------------------------------------");
                flag++;
            }
        }
        if(flag==0)
        {
            System.out.println("Currently You Don't Have Any Appointments!!");
        }else{
            System.out.println("Enter Appointment Id FOR Cancelation or 0 For Exit");
            Scanner sc=new Scanner(System.in);
            int appoint=sc.nextInt();
            if(appoint!=0) {
                ps = con.prepareStatement("update appointment set status=false where ap_id=?");
                ps.setInt(1, appoint);
                ps.executeUpdate();
                System.out.println("Appointment Cancelled SuccessFully!!!");

            }
        }
    }

    void comeback() throws Exception {
        ps = con.prepareStatement("update doctor set leavestatus=false where d_id=?");
        ps.setInt(1, doc_id);
        ps.executeUpdate();
        System.out.println(doc_name + " Is Available Now!!!");
    }

    int doc_id;
    String doc_name;

    boolean checkId(int uid) throws Exception {
        ps = con.prepareStatement("select user_id,d_id,d_name from doctor");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getInt(1) == uid) {
                doc_id = rs.getInt(2);
                doc_name = rs.getString(3);
                System.out.println("Welcome " + doc_name);
                return true;
            }
        }
        return false;
    }
    void makeBill(String name,int total_expance) throws Exception
    {
        if(pDetails.containsValue(getPobject(name)))
        {
            ps= con.prepareStatement("select p_name,p_number,admit_date from patient where p_name=?");
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            rs.next();
            System.out.println("+------------------------------------------------------------+");
            System.out.println("| Name: "+rs.getString("p_name")+"\t\t\t\t\t\t\t\t\t\t\t\t |");
            System.out.println("| Mobile: "+rs.getString("p_number")+"\t\t\t\t\t\t\t\t\t\t |");
            System.out.println("| Admit Date: "+rs.getTimestamp("admit_date")+"\t\t\t\t\t |");
            System.out.println("| Total Expance: "+total_expance+"\t\t\t\t\t\t\t\t\t\t |");
            System.out.println("|\t\tMedicines\t\t\t\t\t\t\t\t\t\t\t |");
            int id=getPid(name);
            ps=con.prepareStatement("select medicines from medicines where p_id=?");
            ps.setInt(1,id);
            ResultSet rs1=ps.executeQuery();
            while (rs1.next())
            {
                System.out.println("|-->"+rs1.getString("medicines")+"\t\t\t\t\t\t   \t\t\t\t\t\t\t\t|");
            }
            System.out.println("+------------------------------------------------------------+");
        }
        else{
            System.out.println("Name Not Found!!");
        }
    }

    void setAppointment(Appointment ap, int d_id) throws Exception {
        ps = con.prepareStatement("select leaveStatus from doctor where d_id=? limit 1");
        ps.setInt(1, d_id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        if (!rs.getBoolean(1)) {
            ps = con.prepareStatement("insert into  appointment (ap_name,ap_number,ap_age,cur_date,d_id,timings) values(?,?,?,CURRENT_DATE,?,?)");
            ps.setString(1, ap.name);
            ps.setString(2, ap.number);
            ps.setInt(3, ap.age);
            ps.setInt(4, ap.d_id);
            ps.setTime(5, ap.timings);
            ps.executeUpdate();
            aDetails.put(getAid(ap.name), ap);
            ps = con.prepareStatement("update doctor set appointment_count=appointment_count+1 where d_id=?");
            ps.setInt(1, d_id);
            ps.executeUpdate();
            System.out.println("Booked Appointment SuccessFully");
            System.out.println("Patient Name: " + ap.name + "\nTimings: " + ap.timings);
        } else {
            System.out.println("Doctor Is On Leave Now!!");
        }
    }

    void leave() throws Exception {
        ps = con.prepareStatement("update doctor set leavestatus=true where d_id=?");
        ps.setInt(1, doc_id);
        ps.executeUpdate();
        System.out.println(doc_name + " Is On Leave Now!");
    }

    void searchPatient(String name) throws Exception {
        if (pDetails.containsValue(getPobject(name))) {
            /* Collection <Patient>c=pDetails.values();
             Set <Integer>s=pDetails.keySet();
            Iterator itr1=s.iterator();
            Iterator itr2=c.iterator();
            while(itr1.hasNext()||itr2.hasNext())
            {*/
            Patient p = pDetails.get(getPid(name));
            System.out.println("Patient Id: " + getPid(name));
            System.out.println("Patient Name: " + p.name);
            System.out.println("Patient Number: " + p.mobile);
            System.out.println("Alloted Room: " + p.allotedRoom);
            System.out.println("Status: " + (p.admitStatus ? "Admitted" : "Discharged"));
            System.out.println("Date Of Birth: " + p.dob);
            System.out.println();

        } else if (aDetails.containsValue(getAobject(name))) {
            /*Collection <Appointment>c=aDetails.values();
            Set <Integer>s=aDetails.keySet();
            Iterator itr1=s.iterator();
            Iterator itr2=c.iterator();
            while(itr1.hasNext()|| itr1.hasNext())
            {*/
            Appointment ap = aDetails.get(getAid(name));
            System.out.println("Appointment Id: " + getAid(name));
            System.out.println("Patient Name: " + ap.name);
            System.out.println("Patient Number: " + ap.number);
            System.out.println("Age: " + ap.age);
            ps = con.prepareStatement("select d_name from doctor where d_id=?");
            ps.setInt(1, ap.d_id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String doctor = rs.getString(1);
            System.out.println("Doctor Name: " + doctor);
            System.out.println("Appointment Timings: " + ap.timings);
        } else {
            System.out.println("Name Does Not Exists In Database!!!");
        }
    }

    void dischargePatient(String name) throws Exception {
        if (pDetails.containsValue(getPobject(name))) {
            int id = getPid(name);
            ps = con.prepareStatement("update room set status=true where r_no=(select alloted_room from patient where p_name=?)");
            ps.setString(1, name);
            ps.executeUpdate();
            ps = con.prepareStatement("update patient set discharging_time=current_timestamp where p_id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps = con.prepareStatement("update patient set p_status=false where p_id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            pDetails.get(id).admitStatus = false;
            System.out.println("Discharged SuccessFully!!");
        } else {
            System.out.println("Patient Not Found!!");
        }
    }

    void sendMedicines(String name, ArrayList<String> medicines) throws Exception {
        int id = getPid(name);
        for (int i = 0; i < medicines.size(); i++) {
            ps = con.prepareStatement("insert into medicines values(?,?)");
            ps.setInt(1, id);
            ps.setString(2, medicines.get(i));
            ps.executeUpdate();
        }
    }

    void addPatient(Patient p) throws Exception {

        ps = con.prepareStatement("select p_id from patient order by p_id desc limit 1");
        ResultSet rs = ps.executeQuery();
        rs.next();
        pDetails.put(rs.getInt(1) + 1, p);
        ps = con.prepareStatement("insert into patient(p_name,p_number,p_status,p_dob,alloted_room,admit_date) values(?,?,?,?,?,current_timestamp)");
        ps.setString(1, p.name);
        ps.setString(2, p.mobile);
        ps.setBoolean(3, p.admitStatus);
        ps.setDate(4, (java.sql.Date) p.dob);
        ps.setString(5, p.allotedRoom);
        ps.executeUpdate();

    }

    void updatePatientDetails(String name, String newName) throws Exception {
        int id = getPid(name);
        ps = con.prepareStatement("update patient set p_name=? where p_name=?");
        ps.setString(1, newName);
        ps.setString(2, name);
        System.out.println(ps.executeUpdate());

        try {
            pDetails.get(id).name = newName;
        }catch(Exception e){
            System.out.println("Name Not Found In System!!!");
        }
    }

    void updatePatientDetails(String name, Date dob) throws Exception {
        int id = getPid(name);
        ps = con.prepareStatement("update patient set p_dob=? where p_name=?");
        ps.setString(2, name);
        ps.setDate(1, (java.sql.Date) dob);
        ps.executeUpdate();
        try {
            pDetails.get(id).dob = dob;
        }catch(Exception e)
        {
            System.out.println("Name Not Found In System!!");
        }
    }

    void updatePatientDetails(String name, String mobile, String methodSaperator) throws Exception {
        int id = getPid(name);
        ps = con.prepareStatement("update patient set p_number=? where p_name=?");
        ps.setString(1, mobile);
        ps.setString(2, name);
        ps.executeUpdate();
        try {
            pDetails.get(id).mobile = mobile;
        }catch(Exception e)
        {
            System.out.println("Name Not Found In System!!");
        }
    }

    void setMap() throws Exception {

        ps = con.prepareStatement("select * from patient");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            pDetails.put(rs.getInt(1), new Patient(rs.getString(2), rs.getBoolean(4), rs.getString(3), rs.getDate(5), rs.getString(6)));
        }
        ps = con.prepareStatement("select * from appointment");
        ResultSet rs1 = ps.executeQuery();
        while (rs1.next()) {
            aDetails.put(rs1.getInt(1), new Appointment(rs1.getString(2), rs1.getInt(4), rs1.getTime(7), rs1.getString(3), rs1.getInt(6)));
        }

    }

    int getPid(String name) throws Exception {
        try {
            ps = con.prepareStatement("select p_id from patient where p_name=? limit 1");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            return -1;
        }
    }

    int getAid(String name) throws Exception {
        try {
            ps = con.prepareStatement("select ap_id from appointment where ap_name=? limit 1");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            return -1;
        }
    }

    Appointment getAobject(String name) throws Exception {
        int id = getAid(name);
        return aDetails.get(id);
    }

    Patient getPobject(String name) throws Exception {
        int id = getPid(name);
        return pDetails.get(id);
    }

    void provideRoom(String name) throws Exception {
        int id = getPid(name);
        Patient p = getPobject(name);
        int flag = 0;
        if (pDetails.containsKey(id)) {
            ps = con.prepareStatement("select * from room");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getBoolean("status")) {
                    p.allotedRoom = rs.getString("r_no");
                    ps = con.prepareStatement("update room set status=false where r_no=?");
                    ps.setString(1, p.allotedRoom);
                    ps.executeUpdate();
                    ps = con.prepareStatement("update patient set alloted_room=? where p_id=?");
                    ps.setString(1, p.allotedRoom);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    System.out.println("Room Alloted: " + p.allotedRoom);
                    flag++;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("No Rooms Are Available At the Moment!!");
            }
        } else {
            System.out.println("Patient Does Not Exists!!!");
        }
    }

    void display() {
        System.out.println(pDetails);
        System.out.println(pDetails);
    }
}