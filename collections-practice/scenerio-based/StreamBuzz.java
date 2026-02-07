using System;
using System.Collections.Generic;
using System.Linq;

public class CreatorStats
{
    public string CreatorName { get; set; }
    public double[] WeeklyLikes { get; set; }

    public static List<CreatorStats> EngagementBoard = new List<CreatorStats>();
}

public class StreamBuzz
{
    public void RegisterCreator(CreatorStats record)
    {
        CreatorStats.EngagementBoard.Add(record);
    }

    public Dictionary<string, int> GetTopPostCounts(List<CreatorStats> records, double likeThreshold)
    {
        Dictionary<string, int> result = new Dictionary<string, int>();

        foreach (var creator in records)
        {
            int count = creator.WeeklyLikes.Count(l => l >= likeThreshold);
            if (count > 0)
            {
                result[creator.CreatorName] = count;
            }
        }

        return result;
    }

    public double CalculateAverageLikes()
    {
        if (CreatorStats.EngagementBoard.Count == 0)
            return 0;

        return CreatorStats.EngagementBoard
            .SelectMany(c => c.WeeklyLikes)
            .Average();
    }

    public static void Main(string[] args)
    {
        Program p = new Program();
        Scanner:
        while (true)
        {
            Console.WriteLine("1. Register Creator");
            Console.WriteLine("2. Show Top Posts");
            Console.WriteLine("3. Calculate Average Likes");
            Console.WriteLine("4. Exit");
            Console.WriteLine("Enter your choice:");

            int choice = int.Parse(Console.ReadLine());

            if (choice == 1)
            {
                Console.WriteLine("Enter Creator Name:");
                string name = Console.ReadLine();

                Console.WriteLine("Enter weekly likes (Week 1 to 4):");
                double[] likes = new double[4];
                for (int i = 0; i < 4; i++)
                {
                    likes[i] = double.Parse(Console.ReadLine());
                }

                CreatorStats cs = new CreatorStats
                {
                    CreatorName = name,
                    WeeklyLikes = likes
                };

                p.RegisterCreator(cs);
                Console.WriteLine("Creator registered successfully");
            }
            else if (choice == 2)
            {
                Console.WriteLine("Enter like threshold:");
                double threshold = double.Parse(Console.ReadLine());

                var result = p.GetTopPostCounts(CreatorStats.EngagementBoard, threshold);

                if (result.Count == 0)
                {
                    Console.WriteLine("No top-performing posts this week");
                }
                else
                {
                    foreach (var item in result)
                    {
                        Console.WriteLine(item.Key + " - " + item.Value);
                    }
                }
            }
            else if (choice == 3)
            {
                double avg = p.CalculateAverageLikes();
                Console.WriteLine("Overall average weekly likes: " + avg);
            }
            else if (choice == 4)
            {
                Console.WriteLine("Logging off - Keep Creating with StreamBuzz!");
                break;
            }
        }
    }
}
