/*
File-like data reader (simulated)

Simulate a DataReader class with open(), read(), close(). open() throws Exception if filename is empty.
read() throws Exception if reader is not opened first. Use try-with-resources pattern by implementing
AutoCloseable — close() must always be called automatically.

try(DataReader dr = new DataReader("data.txt"))
auto calls: open() → read() → close() automatically
on exception:close() still called before catch block runs

Skills: AutoCloseable, try-with-resources, resource management, boolean state guard

 */

public class FileLikeDataReader {
    public static void main(String[] args) {
        try (DataReader dr = new DataReader("Data.txt")){
            dr.read();
        } catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}

class DataReader implements AutoCloseable{
    private String fileName;
    private boolean isOpen = false;

    DataReader(String fileName) throws Exception {
        this.fileName = fileName;
        open();
    }
    public void open() throws Exception{
        if(fileName == null || fileName.isEmpty()){
            throw new Exception("File is empty");
        }
        isOpen = true;
        System.out.println("Opened: "+fileName);
    }

    public void read() throws Exception{
        if(!isOpen){
            throw new Exception("Reader is not open -- first call open()");
        }
        System.out.println("Reading data from: "+fileName+" ...");
    }

    @Override
    public void close(){
        if(isOpen){
            System.out.println("Closed: "+fileName);
            isOpen = false;
        }
    }
}

/*
Why not like this -
DataReader dr = new DataReader("data.txt");
try {
    dr.read();
} catch(){

} finally{
    dr.close();
}



You never call close() — the compiler writes that call for you. try-with-resources isn't a runtime trick;
it's a compile-time transformation. When you write:
try (DataReader dr = new DataReader("data.txt")) {
    dr.read();
}
the Java compiler literally rewrites this into old-style try-finally code before it ever becomes bytecode —
roughly equivalent to:

DataReader dr = new DataReader("data.txt");
try {
    dr.read();
} finally {
    dr.close();   // the compiler inserts this call itself
}
 */