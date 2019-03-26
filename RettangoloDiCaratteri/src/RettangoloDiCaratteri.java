public class RettangoloDiCaratteri
{
	private char carattere, carattere1;
	private int altezza, base, x, y;
	
	public RettangoloDiCaratteri(int x, int y, int base, int altezza)
	{
		this.altezza=altezza;
		this.base=base;
		this.x=x;
		this.y=y;
		carattere='*';
		carattere1='_';
	}
	
	public void draw()
	{	
		for(int i=0; i<y+altezza;i++){
			for(int j=0;j<x+base;j++){
				if (i<y || j<x)
					System.out.print(' ');	
				else
					System.out.print(carattere);
				}
				System.out.println();
			}
			
		}
	public void setCarattere(char carattere){
			this.carattere=carattere;
	}
	public void drawVerticalStripes(){
		for(int i=0; i<y+altezza;i++){
			for(int j=0;j<x+base;j++){
				if (i<y || j<x)
					System.out.print(' ');
				else
					if(j%2==0)
						System.out.print(carattere);
					else
						System.out.print(carattere1);
				}
				System.out.println();
			}
	}
	public void drawHorizontalStripes(){
		for(int i=0; i<y+altezza;i++){
			for(int j=0;j<x+base;j++){
				if (i<y || j<x)
					System.out.print(' ');
				else
					if(i%2==0)
						System.out.print(carattere);
					else
						System.out.print(carattere1);
				}
				System.out.println();
			}
	}
	public void drawChessboard(){
		for(int i=0; i<y+altezza;i++){
			for(int j=0;j<x+base;j++){
				if (i<y || j<x)
					System.out.print(' ');
				else
					if((i+j)%2==0)
						System.out.print(carattere);
					else
						System.out.print(carattere1);
				}
				System.out.println();
			}
	}
	public void setCarattere2(char carattere, char carattere1){
		this.carattere=carattere;
		this.carattere1=carattere;
	}
	public void modificaPosizione(int x,int y ){
		this.x=x;
		this.y=y;
	}
	public String accessoCarattere(){
		String caratteri="I caratteri usati sono: "+carattere+" e "+carattere1;
		return  caratteri;
	}
}