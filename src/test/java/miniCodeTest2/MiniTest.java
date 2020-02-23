package miniCodeTest2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Test;
/**
 * �����ʵ�͸��޿ո���ӣ���ӿո�ʹ֮��Ϊ����ľ���
 * @author wangxiaomin
 * @date 2020��2��17��
 */
public class MiniTest {

	private String sourceDirectory1[]=new String[] {"i","like","sam","sung","samsung","mobile","ice","cream","man go"};
	private String sourceDirectory2[]=new String[] {"i","like","sam","sung","mobile","icecream","man go","mango"};
	private String sourceDirectory3[]=new String[] {};
	private Directory directory1=new Directory();
	private Directory directory2=new Directory();
	private Directory directory3=new Directory();
	
	{
		initSourceDirectory3();
		initDirectorys();
	}
	
	@Test
	public void test() {
		MiniTest mt= new MiniTest();
		String sentence1= "ilikesamsungmobile";
		String sentence2= "ilikeicecreamandmango";
		System.out.println(mt.sentenceSpace(sentence1,directory1));
		System.out.println(mt.sentenceSpace(sentence2,directory1));
		
		System.out.println(mt.sentenceSpace(sentence1,directory2));
		System.out.println(mt.sentenceSpace(sentence2,directory2));
		
		System.out.println(mt.sentenceSpace(sentence1,directory3));
		System.out.println(mt.sentenceSpace(sentence2,directory3));
	}
	
	
	/**
	 * ��װ�ڵ������ʵ�
	 */
	private void initSourceDirectory3()	{
		HashSet<String> hs = new HashSet<String>();
		for(String word:sourceDirectory1) {
			hs.add(word);
		}
		for(String word:sourceDirectory2) {
			hs.add(word);
		}
		sourceDirectory3 = new String[hs.size()];
		Iterator<String> it = hs.iterator();
		for(int i=0;i<hs.size();i++) {
			sourceDirectory3[i]=it.next();
		}
	}
	
	private void initDirectorys() {
		initDirectory(sourceDirectory1,directory1);
		initDirectory(sourceDirectory2,directory2);
		initDirectory(sourceDirectory3,directory3);
	}
	
	private void initDirectory(String sourceDirectory[],Directory directory) {
		Word[] words = new Word[sourceDirectory.length];
		int i  = 0;
		for(String s:sourceDirectory) {
			words[i++]=new Word(s);
		}
		directory.setWords(words);
	}
	
	/**
	 * �����ʵ�͸��޿ո���ӣ���ӿո�ʹ֮��Ϊ����ľ���
	 * 
	 * @param input
	 * @param dictionary
	 * @return
	 */
	public ArrayList<String> sentenceSpace(String input,Directory directory) {
		ArrayList<String> al = new ArrayList<String>();
		for(int i = 0;i<directory.getWords().length;i++) {
			String match =directory.getWords()[i].getMatchWord();
			input = input.replace(match, match+" ");//����ǰ���е� ƥ������ӿո�
			input = getRightString(directory,input);//���鵱ǰ�ַ����Ƿ�Ϸ�,���޳����Ϸ��Ŀո�
		}
		al.add(input);
		HashMap<String, Word> hs  = directory.getAbbreviationMap();
		if(!hs.isEmpty()) {
			Iterator<Entry<String, Word>> it = hs.entrySet().iterator();
			while(it.hasNext()) {
				Entry<String, Word> en = it.next();
				input = input.replace(en.getKey(), en.getValue().getWord());
				al.add(input);
			}
		}
		return al;
	}
	
	/**
	 * ���鵱ǰ�ַ����Ƿ�Ϸ������Դ����Ƿ��ܴӴʵ����������������޳����Ϸ��Ŀո񣬷�����ԺϷ�����
	 * @param input
	 * @return
	 */
	private String getRightString(Directory directory,String input) {
		String arr[] = input.split(" ");
		String result ="";
		for(int j=0;j<arr.length;j++){
			if(!contains(directory.getWords(),arr[j])) {
				result += arr[j];
			}else {
				result += arr[j]+" ";
			}
		}
		return result;
	}
	
	/**
	 *  �ַ��������Ƿ����ĳ�ַ���
	 * @param arr �ַ�������
	 * @param str �ַ���
	 * @return �Ƿ����
	 */
	private  boolean contains(Word[] arr,String str) {
		for(Word s:arr) {
			if(s.equals(str)) {
				return true;
			}
		}
		return false;
	}
	
}
