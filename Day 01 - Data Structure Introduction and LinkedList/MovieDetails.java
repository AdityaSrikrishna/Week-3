

class Movie{
    String title;
    String director;
    int year;
    double rating;
    Movie prev;
    Movie next;
    public Movie(String title, String director, int year, double rating){
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}
class MovieList{
    public Movie head = null;
    public Movie tail = null;
    public void addatBeginning(Movie newMovie){
        if(head==null){
            head = tail = newMovie;
        }
        else{
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }
    public void addatEnd(Movie newMovie){
        if(tail==null){
            head = tail = newMovie;
        }
        else{
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }
    public void addatPosition(Movie newMovie, int position){
        if(position<=1 || head==null){
            addatBeginning(newMovie);
            return;
        }
        Movie temp = head;
        for(int i=1; temp.next!=null && i<position-1; i++){
            temp = temp.next;
        }
        if(temp.next==null){
            addatEnd(newMovie);
        }
        else{
            newMovie.next = temp.next;
            newMovie.prev = temp;
            temp.next.prev = newMovie;
            temp.next = newMovie;
        }
    }
    public void deletebytitle(String title){
        Movie temp = head;
        while(temp!=null){
            if(temp.title.equalsIgnoreCase(title)){
                if(temp==head){
                    head = head.next;
                    if(head!=null) head.prev = null;
                    else tail = null;
                }
                else if(temp==tail){
                    tail = tail.prev;
                    tail.next = null;
                }
                else{
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Movie removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }
    public void getmoviebydirector(String director){
        Movie current = head;
        boolean found = false;
        while(current!=null){
            if(current.director.equalsIgnoreCase(director)){
                displayMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found for director: " + director);
    }
    public void getbyrating(double rating){
        Movie current = head;
        boolean found = false;
        while(current!=null){
            if(current.rating == rating){
                displayMovie(current);
                found = true;
            }
            current = current.next;
        }
        if(!found) System.out.println("No movie found for rating " + rating);
    }
    public void setrating(String title, double newrating){
        Movie current = head;
        boolean found = false;
        while(current!=null){
            if(current.title.equalsIgnoreCase(title)){
                current.rating = newrating;
                System.out.println("Rating updated for " + title);
                found = true;
            }
            current = current.next;
        }
        if(!found) System.out.println("No movie " + title + " was found.");
    }
    public void displayforward(){
        Movie current = head;
        System.out.println("Movies (Forward):");
        while(current!=null){ 
            displayMovie(current);
            current = current.next;
        }
    }
    public void displaybackward(){
        Movie current = tail;
        System.out.println("Movies (Backward):");
        while(current!=null){
            displayMovie(current);
            current = current.prev;
        }
    }
    public void displayMovie(Movie movie){
        System.out.println("Title: " + movie.title + " Director: " + movie.director + " Year: " + movie.year + " Rating: " + movie.rating);
    }
}
public class MovieDetails{
    public static void main(String[] args) {
        MovieList manager = new MovieList();
        manager.addatEnd(new Movie("Inception", "Christopher Nolan", 2010, 8.8));
        manager.addatBeginning(new Movie("The Matrix", "Lana Wachowski", 1999, 8.7));
        manager.addatPosition(new Movie("Interstellar", "Christopher Nolan", 2014, 8.6), 2);

        manager.displayforward();
        manager.displaybackward();

        manager.setrating("Inception", 9.0);
        manager.getmoviebydirector("Christopher Nolan");
        manager.getbyrating(8.7);

        manager.deletebytitle("The Matrix");
        manager.displayforward();
    
    }
}