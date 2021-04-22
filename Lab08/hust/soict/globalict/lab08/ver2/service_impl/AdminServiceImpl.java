package hust.soict.globalict.lab08.ver2.service_impl;

import hust.soict.globalict.lab08.ver2.model.media.Book;
import hust.soict.globalict.lab08.ver2.model.media.CD;
import hust.soict.globalict.lab08.ver2.model.media.DVD;
import hust.soict.globalict.lab08.ver2.model.media.Track;
import hust.soict.globalict.lab08.ver2.service.AdminService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminServiceImpl implements AdminService {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public float setupCost(){
        float cost;
        try{
            System.out.print("Input cost : ");
            String tmp = sc.nextLine();

            if (tmp.equals("")){
                return -1;
            }

            cost = Float.parseFloat(tmp);

            if (cost <= 0){
                System.out.println("wtf ??? cost must be a positive number");
                return setupCost();
            }

            return cost;
        } catch (Exception e){
            System.out.println("wtf ??? cost must be a positive number");
            return setupCost();
        }
    }

    @Override
    public String setupTitle(){
        System.out.print("Input title : ");
        String tmp = sc.nextLine();
        if (tmp.equals("")){
            return null;
        }
        return tmp;
    }

    @Override
    public String setpuCategory(){
        System.out.print("Input category : ");
        String tmp = sc.nextLine();
        if (tmp.equals("")){
            return null;
        }
        return tmp;
    }

    @Override
    public int setupLength(){
        int length;
        try{
            System.out.print("Input length (sec) : ");
            String tmp = sc.nextLine();
            if (tmp.equals("")){
                return -1;
            }
            length = Integer.parseInt(tmp);
            if (length <= 0){
                System.out.println("wtf ??? length must be a positive INTEGER");
                return setupLength();
            }
            return length;
        } catch (Exception e){
            System.out.println("wtf ??? length must be a positive INTEGER");
            return setupLength();
        }
    }

    @Override
    public String setupDirector(){
        System.out.print("Input director : ");
        String tmp = sc.nextLine();
        if (tmp.equals("")){
            return null;
        }
        return tmp;
    }

    @Override
    public List<String> setupAuthors(){
        List<String> authors = new ArrayList<String>();
        System.out.print("How many authors ? : ");
        int num;
        try{
            String tmp = sc.nextLine();
            if (tmp.equals("")){
                return null;
            }

            num = Integer.parseInt(tmp);
            if (num <= 0){
                System.out.println("wtf ??? number of authors must be a positive INTEGER");
                return setupAuthors();
            }

            for (int i = 1; i <= num; i++){
                System.out.print("Input author number "+i+" : ");

                tmp = sc.nextLine();
                if(tmp.equals("")){
                    return null;
                }

                if (!authors.contains(tmp)){
                    authors.add(tmp);
                } else {
                    System.out.println("*That author already exists (will be filtered out)*");
                }

            }

            return authors;

        } catch (Exception e){
            System.out.println("wtf ??? number of authors must be a positive INTEGER");
            return setupAuthors();
        }
    }

    @Override
    public String setupArtist(){
        System.out.print("Input artist : ");
        String tmp = sc.nextLine();
        if (tmp.equals("")){
            return null;
        }
        return tmp;
    }

    @Override
    public Track setupTrack(int i, int num){
        String title;
        int length;

        if (num == 1 && i == 1){
            System.out.print("Input title of track : ");
        } else {
            System.out.print("Input title of track "+i+" : ");
        }

        title = sc.nextLine();
        if(title.equals("")){
            return null;
        }

        length = setupLengthTrack(i, num);
        if(length == -1){
            return null;
        }

        return new Track(title, length);
    }

    private int setupLengthTrack(int i, int num){
        int length;
        try{

            if (num == 1 && i == 1){
                System.out.print("Input length (sec) of track : ");
            } else {
                System.out.print("Input length (sec) of track "+i+" : ");
            }

            String tmp = sc.nextLine();
            if (tmp.equals("")){
                return -1;
            }
            length = Integer.parseInt(tmp);
            if (length <= 0){
                System.out.println("wtf ??? length must be a positive INTEGER");
                return setupLengthTrack(i, num);
            }
            return length;
        } catch (Exception e){
            System.out.println("wtf ??? length must be a positive INTEGER");
            return setupLengthTrack(i, num);
        }
    }

    @Override
    public Book setupBook(){
        String title = setupTitle();
        if(title == null){
            return null;
        }

        String category = setpuCategory();
        if(category == null){
            return null;
        }

        float cost = setupCost();
        if (cost == -1){
            return null;
        }

        List<String> authors = setupAuthors();
        if (authors == null){
            return null;
        }

        return new Book(title, category, cost, authors);
    }

    @Override
    public DVD setupDVD(){
        String title = setupTitle();
        if(title == null){
            return null;
        }

        String category = setpuCategory();
        if (category == null){
            return null;
        }

        float cost = setupCost();
        if (cost == -1){
            return null;
        }

        String director = setupDirector();
        if (director == null){
            return null;
        }

        int length = setupLength();
        if (length == -1){
            return null;
        }

        return new  DVD(title, category, director, length, cost);
    }

    @Override
    public CD setupCD(){
        String title = setupTitle();
        if(title == null){
            return null;
        }

        String category = setpuCategory();
        if (category == null){
            return null;
        }

        float cost = setupCost();
        if (cost == -1){
            return null;
        }

        String director = setupDirector();
        if (director == null){
            return null;
        }

        String artis = setupArtist();
        if(artis == null){
            return null;
        }

        int num = setupNumberOfTrack();
        if(num == -1){
            return null;
        }

        CD cd = new CD(title, category, cost, director, artis);
        List<Track> tracks = new ArrayList<Track>();

        outerloop:
        for (int i = 1; i <= num; i++){
            Track track = setupTrack(i, num);
            if(track == null){
                return null;
            }
            for (Track t : tracks){
                if(t.equals(track)){
                    System.out.println("*That track already exists (will be filtered out)*");
                    continue outerloop;
                }
            }
            tracks.add(track);
        } // filter stage

        for (Track t : tracks){
            cd.addTrack(t);
        } // input stage

        return cd;
    }

    public int setupNumberOfTrack(){
        System.out.print("Input number of tracks of this CD : ");

        int num;
        try{
            String tmp = sc.nextLine();
            if (tmp.equals("")){
                return -1;
            }

            num = Integer.parseInt(tmp);
            if (num <= 0){
                System.out.println("wtf ??? number of tracks must be a positive INTEGER");
                return setupNumberOfTrack();
            }

            return num;

        } catch (Exception e){
            System.out.println("wtf ??? number of tracks must be a positive INTEGER");
            return setupNumberOfTrack();
        }
    }
}
