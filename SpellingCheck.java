import java.util.*;

public class SpellingCheck
{
	private Set<String> dico,validWords;
	private List<String> search;
	private String value,searchValue,error;
	private Scanner input;
	
	public SpellingCheck()
	{
		dico = new HashSet<String>();
		validWords = new HashSet<String>();
		search = new ArrayList<>();
		input = new Scanner(System.in);
		value = "";
		searchValue = "";
		loadDictionaryAndSearchWord();
	}
	private void loadDictionary()
	{
		while(!value.equals("*"))
		{
			value = input.nextLine();
			dico.add(value);
			System.out.println("Enter next dictionary word or * to end");
		}
	}
	private void loadSearch()
	{
		while(!searchValue.equals("*"))
		{
			searchValue = input.nextLine();
			search.add(searchValue);
			System.out.println("Enter next search word r * to end");
		}
	}
	private void loadDictionaryAndSearchWord()
	{
		System.out.println("Enter dictionary words and * to end");
		loadDictionary();
		while(true)
		{
			System.out.println("Enter your mistype word for correction");
			loadSearch();
			checkSearchForError();
			displayquessWords();
			search.clear();
			validWords.clear();
			searchValue = "";
		}
	}
	private void checkSearchForError()
	{
		for(String search: this.search)
		{
			if(!dico.contains(search))
			{
				error = search;
				checkTranspose();
				checkOmitting();
				checkMistype();
			}
		}
	}
	private void checkTranspose()
	{
		for(int j=0; j < error.length()-1; j++)
		{
			char [] tempWord = error.toCharArray();
			char temp = tempWord[(j+1)];
			tempWord[(j+1)] = tempWord[j];
			tempWord[j] = temp;
			String text = String.valueOf(tempWord);
			if(dico.contains(text))
			{
				validWords.add(text);
				break;
			}
		}
	}
	private void checkOmitting()
	{
		for(String dico : this.dico)
		{
			StringBuilder tempDico = new StringBuilder(dico);
			for(int j=0; j<tempDico.length(); j++)
			{
				char tempChar = tempDico.charAt(j);
				tempDico.deleteCharAt(j);
				if(String.valueOf(tempDico).equals(error))
				{
					validWords.add(dico);
					break;
				}
				tempDico.insert(j, tempChar);
			}
		}
	}
	private void checkMistype()
	{
		StringBuilder temp = new StringBuilder(error);
		for(int i=0; i<temp.length(); i++)
		{
			char tempChar = temp.charAt(i);
			temp.deleteCharAt(i);
			error = String.valueOf(temp);
			checkOmitting();
			temp.insert(i, tempChar);
		}
	}
	private void displayquessWords()
	{
		System.out.println(validWords);
	}
	public static void main(String [] args)
	{
		new SpellingCheck();
	}
}