package com.behavioral.COR;

import java.util.*;
 
abstract class Logger 
{
    public static int ERR = 3;
    public static int NOTICE = 5;
    public static int DEBUG = 7;
    protected int mask;
 
    // The next element in the chain of responsibility
    protected Logger next;
    public Logger setNext( Logger l )
    {
        next = l;
        return l;
    }
 
    public void message( String msg, int priority )
    {
        if ( priority <= mask ) 
        {
            writeMessage( msg );
        }
        if ( next != null )
        {
            next.message( msg, priority );
        }
    }
 
    abstract protected void writeMessage( String msg );
 
}
 
class StdoutLogger extends Logger 
{
    public StdoutLogger( int mask ) { this.mask = mask; }
 
    protected void writeMessage( String msg )
    {
        System.out.println( "Writing to stdout: " + msg );
    }
}
 
 
class EmailLogger extends Logger 
{
 
    public EmailLogger( int mask ) { this.mask = mask; }
 
    protected void writeMessage( String msg )
    {
        System.out.println( "Sending via email: " + msg );
    }
}
 
class StderrLogger extends Logger 
{
    public StderrLogger( int mask ) { this.mask = mask; }
    protected void writeMessage( String msg )
    {
        System.err.println( "Sending to stderr: " + msg );
    }
}
 
public class CORDemo
{
    public static void main( String[] args )
    {
        // Build the chain of responsibility
        Logger l,l1;
        l1 = l = new StdoutLogger( Logger.DEBUG );
        l1 = l1.setNext(new EmailLogger( Logger.NOTICE ));
        l1 = l1.setNext(new StderrLogger( Logger.ERR ));
 
        // Handled by StdoutLogger
        l.message( "Entering function y.", Logger.DEBUG );
 
        // Handled by StdoutLogger and EmailLogger
        l.message( "Step1 completed.", Logger.NOTICE );
 
        // Handled by all three loggers
        l.message( "An error has occurred.", Logger.ERR );
    }
}
