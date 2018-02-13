// **********************************************************
// Author: djoyce
// Date: Jan 25, 2015
//
// Histogram objects keep track of the counts of submitted 
// numbers, and provide a nicely formatted string representing
// a histogram of the totals.
// ***********************************************************

public interface HistogramInterface
{
    final static int MAXWIDTH = 30;   // histogram "bars" max width

    public void submit (int value);
    // Submits "value" to this histogram.
    // Throws HistogramOutOfBounds exception if value not within range.

    public String toString ();
    // Returns a nicely formatted string representing this histogram.
}