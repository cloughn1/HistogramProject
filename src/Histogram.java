// **********************************************************
// Author: djoyce
// Date: Jan 25, 2015
//
// Histogram objects keep track of the counts of submitted 
// numbers, and provide a nicely formatted string representing
// a histogram of the totals.
// ***********************************************************

public class Histogram implements HistogramInterface
{
	protected int min, max;
	protected int[] counts;

	public Histogram(int min, int max)
	{
		this.min = min;
		this.max = max;
		counts = new int[max - min + 1];
	}

	public Histogram(int max)
	{
		this.min = 1;
		this.max = max;
		counts = new int[max - min + 1];
	}

	public void submit(int i) throws HistogramOutOfBoundsException
	{
		if ((min <= i) && (i <= max))
			counts[i-min] += 1;
		else
		{
			String message = "\n*******\n";
			message += "Submitted value " + i + " is outside range [";
			message += min + "," + max + "]" + " of Histogram.\n";
			message += "*******\n";
			throw new HistogramOutOfBoundsException(message);
		}
	}

	public String toString()
	{
		int weight;    // value of a single *
		int num;       // number of *'s to print

		// calculate weight
		int highIndex = 0;
		for (int i = 1; i < counts.length; i++)
			if (counts[highIndex] < counts[i])
				highIndex = i;

		weight = ((counts[highIndex] - 1) / MAXWIDTH) + 1;

		// create "header"
		String histoString ="\n";

		if (weight != 1)
			histoString += "* = approximately " + weight + " occurrences\n\n";

		// create histogram
		for (int i = 0; i <= max - min; i++)
		{
			histoString += String.format("%4d",(i + min)) + ": ";
			if (counts[i] == 0)
				num = 0;
			else
				num = ((counts[i] - 1) / weight ) + 1;
			for (int j = 0; j < num; j++)
				histoString += "*";
			histoString += "\n";
		}

		return histoString;
	}
}