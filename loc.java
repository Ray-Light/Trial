import java.io.*;
import java.util.*;
import java.lang.*;
import org.checkerframework.checker.index.qual.*;

class loc
{
	
	public static void main(String[] args)
	{
		System.out.println("Enter file name : ");
		Scanner scan = new Scanner(System.in);
		String filename = scan.next();
		filename = "/home/ravi/" + filename;
		
		int i, l, j, k, flag = 0, c = 0;
		
		try (Scanner read = new Scanner(new File(filename)))
		{
			read.useDelimiter("\n");
			
			String str;
			
			while(read.hasNext())
			{
				str = read.next();
				l = str.length();
				
				if(l == 0)
				{
					continue;
				}
			    if(flag == 0)
			    {
			        for(i=0;i<l;i++)
			        {
						@IndexFor("str") int uv;
						if(i+1 < l)
							uv = i+1;
						else
							break;
			            if(str.charAt(i) == '/' && str.charAt((uv)) == '/')
			                break;
			            else if(str.charAt(i) == '/' && str.charAt(uv) == '*')
			            {
			                flag = 1;
			                for(j=i;j<l-1;j++)
			                {
			                	if(str.charAt(j) == '*' && str.charAt(j+1) == '/')
			                	{
			                		flag = 0;
			                		break;
			                	}
			                }
			                if(flag == 0 && j+2<l)
			                {
			                	i=j+2;
			                	continue;
			                }
			                break;
			            }
			            else
			            {
			            
			            }
			        }
			        if (flag == 0)
			        {
			            c++;
			        }
			    }
			    else
			    {
			        for(k=1;k<l;k++)
			        {
			            if(str.charAt(k) == '/' && str.charAt(k-1) == '*')
			            {
			                flag = 0;
			                break;
			            }
			        }
			        if(flag == 0 && k != l-1)
			        {
			            for (j = k+2; j < l; j++)
			            {
			            
			            }
			            c++;
			        }
			    }

			    l = 0;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	
		System.out.println((float)(c/1000.0) + " kloc");
	}
}
