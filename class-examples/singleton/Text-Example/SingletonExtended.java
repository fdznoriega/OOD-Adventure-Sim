class Singleton {
    protected static Singleton unique;
    protected Singleton(){}
    public static Singleton makeInstanceOfSingleton() {
        if ( unique != null )
            return unique;
        else {
            unique = new Singleton();
            return unique;
        }
    }
}

class SingletonExtended extends Singleton {
    private static SingletonExtended unique;
    public static SingletonExtended makeInstanceOfSingletonExtended() {
        if ( unique != null )
            return unique;
        else {
            unique = new SingletonExtended();
            return unique;
        }
    }

}

class TestSingletonExtended {
    public static void main( String[] args )
    {
        Singleton obj_1 = Singleton.makeInstanceOfSingleton();
        Singleton obj_2 = Singleton.makeInstanceOfSingleton();
        if ( obj_1 == obj_2 )
            System.out.println( 
                    "The two Singleton objects are the same" );
        SingletonExtended obj_3 =  
                  SingletonExtended.makeInstanceOfSingletonExtended();
        SingletonExtended obj_4 =  
                  SingletonExtended.makeInstanceOfSingletonExtended();
        if ( obj_3 == obj_4 )
            System.out.println( 
                    "The two SingletonExtended objects are the same" );
    }
}
