class UnauthorizedInstanceException extends Exception {
    public UnauthorizedInstanceException() {
        super();
    }
    public UnauthorizedInstanceException( String message ) {
        super( message );
    }
}

class Singleton {
    static boolean instanceExists = false;

    public Singleton() throws UnauthorizedInstanceException {
        if ( instanceExists ) {
            throw new UnauthorizedInstanceException( 
                    "Unique instance constructed previously." 
                 +  " New instance creation request denied." );
        } else {
            instanceExists = true;
            System.out.println("Unique instance of Singleton created");
        }
    }
}

class TestSingleton {
    public static void main( String[] args )
    {
        // First attempt works fine:
        try {        
            Singleton obj_1 = new Singleton();
        } catch( UnauthorizedInstanceException u ) {
            System.out.println( u.getMessage() );
        }

        // Second attempt causes an exception to be thrown:
        try {        
            Singleton obj_2 = new Singleton();
        } catch( UnauthorizedInstanceException u ) {
            System.out.println( u.getMessage() );
        }
    }
}
