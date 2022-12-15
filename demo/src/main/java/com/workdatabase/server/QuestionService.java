package com.workdatabase.server;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class QuestionService {
    //用户积分榜存储器
    public static class inter_Static{
        public String name;//姓名
        public String gra_time;//毕业年份
        public String major;//专业
        public int total_inter;//总积分
    }
    //答题记录存储器
    public static class inter_Record {
        public String time;//答题时间
        public int gain;//获得分数
    }
    //题目存储器
    public static class q_Saver {
        public String title;
        public String A;
        public String B;
        public String C;
        public String D;
        public String correct;
    }
    //把云部署时间更改为本地时间
    public Date dayAddAndSub(int currentDay,int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(currentDay, day);
        return calendar.getTime();
    }
    //随机数生成
    public int[] rand(int num){
        int n = 50;
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int[] getInt = new int[num];
        int randInt;
        for (int i=0;i<num;i++){
            do {
                randInt = rand.nextInt(n)+1;
            }while (bool[randInt]);
            bool[randInt] = true;
            getInt[i]=randInt;
        }
        return getInt;
    }
    //获取记录条数
    public int get_Record_Length(String id){
        Connection con;
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://sh-cynosdbmysql-grp-dahz4tww.sql.tencentcdb.com:28835/test";
        String username="zwj";
        String password="Www7k7kcom";
        int len = 0;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            Statement statement = con.createStatement();
            String sql1 = String.format("select count(*) from inter_record where openId='%s'",id);
            ResultSet rs = statement.executeQuery(sql1);
            if (rs.next())
                len = rs.getInt("count(*)");
            rs.close();
            statement.close();
            con.close();
        }catch (ClassNotFoundException e){
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return len;
    }
    //插入新的答题记录
    public void insert_Record(String id,int score){
        /*
        1.拉取系统时间
        2.存入id + time + score
        3.同步更新总积分
         */
        Date date = new Date();//获取当前的日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH+8:mm:ss");//设置日期格式
        Date dateResult = this.dayAddAndSub(Calendar.HOUR,+8);
        String time = df.format(dateResult);//获取String类型的时间
        Connection con;
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://sh-cynosdbmysql-grp-dahz4tww.sql.tencentcdb.com:28835/test";
        String username="zwj";
        String password="Www7k7kcom";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            if(!con.isClosed())
                System.out.println("成功连接数据库");
            String sql1 = String.format("insert into inter_record value ('%s','%s','%d');",id,time,score);
            String sql2 = String.format("update inter_static set total_inter=total_inter+'%d' where openId='%s'",score,id);
            String sql3 = String.format("update certified set money=money+'%d' where openId='%s'",score,id);
            Statement state = con.createStatement();
            state.execute(sql1);
            state.execute(sql2);
            state.execute(sql3);
            state.close();
            con.close();
        }catch (ClassNotFoundException e){
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("成功存入一条答题记录！");
        }
    }
    //获取答题排行榜
    public List<inter_Static> get_Inter_Static(){
        Connection con;
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://sh-cynosdbmysql-grp-dahz4tww.sql.tencentcdb.com:28835/test";
        String username="zwj";
        String password="Www7k7kcom";
        inter_Static[] receive = new inter_Static[5];//设置需要返回的人数：此处设置为返回前五名*SQL语句需要同步更改
        for(int i = 0 ; i < receive.length ;i++)
            receive[i] = new inter_Static();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            Statement statement = con.createStatement();
            String sql = "select name,graduationTime,major,total_inter " +
                    "from certified,inter_static where " +
                    "certified.openId=inter_static.openId order by total_inter desc limit 5";
//            String sql = "select name,graduationTime,major,money from certified order by money desc limit 5";
            ResultSet rs = statement.executeQuery(sql);
            int i =0 ;
            while (rs.next())
            {
                receive[i].name= rs.getString("name");
                receive[i].gra_time = rs.getString("graduationTime");
                receive[i].major = rs.getString("major");
                receive[i].total_inter = rs.getInt("total_inter");
                i++;
            }
            rs.close();
            statement.close();
            con.close();
        }catch (ClassNotFoundException e){
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        List<inter_Static> list = new ArrayList<>();
        Collections.addAll(list,receive);
        return list;
    }
    //获取用户答题记录
    public List<inter_Record> get_Inter_Record(String id){
        Connection con;
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://sh-cynosdbmysql-grp-dahz4tww.sql.tencentcdb.com:28835/test";
        String username="zwj";
        String password="Www7k7kcom";
        int len = get_Record_Length(id);
        inter_Record[] receive = new inter_Record[len];
        for(int i = 0 ; i < receive.length ;i++)
            receive[i] = new inter_Record();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            if(!con.isClosed())
                System.out.println("成功连接数据库");
            Statement statement = con.createStatement();
            String sql1 = String.format("select * from inter_record where openId='%s'",id);
            ResultSet rs = statement.executeQuery(sql1);
            int i =0 ;
            while (rs.next())
            {
                receive[i].time= rs.getString("time");
                receive[i].gain = rs.getInt("gain");
                i++;
            }
            rs.close();
            statement.close();
            con.close();
        }catch (ClassNotFoundException e){
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据获取成功");
        }
        List<inter_Record> list = new ArrayList<>();
        Collections.addAll(list, receive);
        return list;
    }
    //获取题库
    public List<q_Saver> get_Question(int num){
        Connection con;
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://sh-cynosdbmysql-grp-dahz4tww.sql.tencentcdb.com:28835/test";
        String username="zwj";
        String password="Www7k7kcom";
        q_Saver[] que = new q_Saver[num];
        for(int i = 0;i<num;i++)
            que[i] = new q_Saver();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            if(!con.isClosed())
                System.out.println("成功连接数据库");
            Statement statement = con.createStatement();
            int[] keyId = rand(num);
            for(int i=0;i<num;i++){
                String sql = String.format("select * from question where keyId = '%d'",keyId[i]);
                ResultSet rs = statement.executeQuery(sql);
                if(rs.next()){
                    que[i].title = rs.getString("question");
                    que[i].A = rs.getString("A");
                    que[i].B = rs.getString("B");
                    que[i].C = rs.getString("C");
                    que[i].D = rs.getString("D");
                    que[i].correct = rs.getString("correct");
                }
                rs.close();
            }
            con.close();
        }catch (ClassNotFoundException e){
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("数据库数据获取成功");
        }
        List<q_Saver> list = new ArrayList<>();
        Collections.addAll(list, que);
        return list;
    }
    //获取当前积分
    public int get_Money(String id){
        Connection con;
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://sh-cynosdbmysql-grp-dahz4tww.sql.tencentcdb.com:28835/test";
        String username="zwj";
        String password="Www7k7kcom";
        int money = 0;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            Statement statement = con.createStatement();
            String sql1 = String.format("select money from certified where openId='%s'",id);
            ResultSet rs = statement.executeQuery(sql1);
            if (rs.next())
                money = rs.getInt("money");
            rs.close();
            statement.close();
            con.close();
        }catch (ClassNotFoundException e){
            System.out.println("Sorry,can't find the Driver!");
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return money;
    }
}
