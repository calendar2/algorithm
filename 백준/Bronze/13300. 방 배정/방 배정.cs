using System.Linq;
using System.Collections;
using System.Collections.Generic;
class Mainn {
  static void Main(string[] args) {
    int[] cond = Array.ConvertAll(Console.ReadLine().Split(' '), x => int.Parse(x));
    int n = cond[0];
    int max = cond[1];
    List<List<int>> raw = new List<List<int>> {
      new List<int> { 0, 0 },
      new List<int> { 0, 0 },
      new List<int> { 0, 0 },
      new List<int> { 0, 0 },
      new List<int> { 0, 0 },
      new List<int> { 0, 0 }
    };
    while (n-->0) {
      int[] a = Array.ConvertAll(Console.ReadLine().Split(' '), x => int.Parse(x));
      raw[a[1]][a[0]]++;
    }
    List<int> temp = raw.ConvertAll(x => x.ConvertAll(y => (int)Math.Ceiling((double)y / max)).Aggregate((a, b) => a + b));
    Console.WriteLine(temp.Aggregate((a, b) => a + b).ToString());
  }
}