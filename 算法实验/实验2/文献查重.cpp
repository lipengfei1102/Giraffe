
#include <stdio.h>

#include <stdlib.h>

#include <iostream>

#include <iomanip>

#include <string>

#include <string.h>

#include <sstream>

#include <cstdlib>

#include <fstream>

#include <cassert>

#include <algorithm>

#include <math.h>

#include <iterator>

#include <cctype>

 

using namespace std;

 

typedef struct Sentence{

    string sentence;	//��¼����

    int num;			//��¼���ӵ��ʸ���

}Sentence;     

 

typedef struct sameSentence{

    string libsent;     //��¼�Ե�����������е�lib�ľ���

	string textsent;    //��¼test�жԱȵľ���

    int textnum;		//��¼test�жԱȵľ��ӵĵ��ʵĸ���

	int samenum;	    //����������еĵ��ʸ���

}sameSentence;

 

sameSentence saveall[1000];   //�洢���жԱȺõ���Ϣ

 

Sentence libSentence[1000];     //����洢lib�ļ�������

int wordSimilarity[1000][1000];  

float Score[1000][1000];      //��¼����������еĵ÷�

string str1[1000],str2[1000];   //�洢ÿ�����ӷָ�����ĵ���

     

int libline = 0;     //lib�ļ��ľ��ӵĸ���

int testline = 0;    //test�ļ��ľ��ӵĸ���

 

void libtxtToSentence( string file);  // ��lib������ݰ����Ӵ洢

void textToSentence( string file );   // ��ȡtext�ı������ݲ�ʹ�ö�̬�滮���в���

float max( float a, float b );

float maxthree( float a, float b, float c );

 

 

int main()

{

	int j;

	string libfile = "lib.txt";

	string textfile = "text.txt";

 

	libtxtToSentence( libfile );

 

	textToSentence( textfile );

 

	for( j=0; j<testline; j++ )

	{

		cout<<"��"<<j+1<<"��Ա�"<<endl;

		cout<<saveall[j].textsent<<endl;

		cout<<saveall[j].libsent<<endl;

		cout<<saveall[j].samenum<<"\t"<<saveall[j].textnum<<endl;

		cout<<"\n"<<endl;

	}

 

	return 0;

}

 

 

void libtxtToSentence( string file )   // ��lib������ݰ����Ӵ洢

{

    ifstream infile; 

    infile.open( file.data() );   //���ļ����������ļ��������� 

    assert( infile.is_open() );   //��ʧ��,�����������Ϣ,����ֹ�������� 

 

    char currentChar;

	string tempSentence="";

	Sentence temp;

	int num1 = 0;

 

    infile >> noskipws;

 

    while ( !infile.eof() )

    {

        infile>>currentChar;

 

		if((( currentChar >='a' )&&( currentChar <='z' ))||(( currentChar >='A' )&&( currentChar <='Z' )))

		{

			tempSentence += currentChar;

 

		}else if(( currentChar =='.' )||( currentChar =='?' )||( currentChar =='!' ))

		{

			transform(tempSentence.begin(), tempSentence.end(), tempSentence.begin(), ::tolower);

			temp.num = num1+1;

			temp.sentence = tempSentence;

			libSentence[libline] = temp;     //��ÿ���Ӵ洢lib�����ݵ�libSentence[]��

			num1 = 0;

			tempSentence = "";

			libline++;      //lib�ļ��ľ��ӵĸ���

		}else    //ƥ�䵽�ո�

		{

			if( tempSentence=="" )

			{

				continue;

			}

			else if(tempSentence[tempSentence.size()==1?1:tempSentence.size()-1] != ' ')  //ƥ�䵽�ո񣬵�ǰ��ĩ��Ϊ�ո���ӿո�

			{

				tempSentence += " ";

				num1 += 1;    //���ʸ�����1

			}

		}

    }

    infile.close();             //�ر��ļ������� 

}

 

 

void textToSentence( string file )    // ��ȡtext�ı������ݲ�ʹ�ö�̬�滮���в���

{

    ifstream infile; 

    infile.open( file.data() );   //���ļ����������ļ��������� 

    assert( infile.is_open() );   //��ʧ��,�����������Ϣ,����ֹ�������� 

 

    char currentChar;

	string tempSentence="";

	Sentence temp;

	int num1 = 0;

 

    infile >> noskipws;

 

    while ( !infile.eof() )

    {

        infile>>currentChar;

 

		if((( currentChar >='a' )&&( currentChar <='z' ))||(( currentChar >='A' )&&( currentChar <='Z' )))

		{

			tempSentence += currentChar;

 

		}else if(( currentChar =='.' )||( currentChar =='?' )||( currentChar =='!' ))   //���һ�����ӵĶ�ȡ�����ж�̬�滮ƥ�����

		{

			transform(tempSentence.begin(), tempSentence.end(), tempSentence.begin(), ::tolower);

			temp.num = num1+1;            // �ѵ�ǰ��ȡ����test���ӵĵ��ʸ�������

			temp.sentence = tempSentence;  // �ѵ�ǰ��ȡ����test���Ӵ��� 

			num1 = 0;

			tempSentence = "";

 

			for(int i=0;i<libline-1;i++ )   //�ֱ���lib�е�ÿһ����жԱ�

			{

				string t;

				int n = 0;

				int k,j;

 

				for(istringstream is(temp.sentence); is>>t;) {   //�洢��test�ľ��ӷָ�����ĵ���

					str1[n++] = t;

				}

 

				n = 0;

				for(istringstream is1(libSentence[i].sentence); is1>>t;) {   //�洢��lib�ľ��ӷָ�����ĵ���

					str2[n++] = t;

				}

 

				for( k=0;k<temp.num;k++)   //test��ǰ���ӵĸ���

				{

					for( j=0;j<libSentence[i].num;j++)  //��lib�ļ��ľ��ӵĵ��ʷֱ���жԱ�

					{

						if(str1[k]==str2[j])

							wordSimilarity[k][j] = 1;

						else

							wordSimilarity[k][j] = 0;

					}

				}

				

				for(k=0; k<temp.num; k++)

				{  

					Score[k][0] = max(Score[k-1][0]-0.5, wordSimilarity[k][0]-0.5*(k-1) );

				} 

				for(k=0; k<libSentence[i].num; k++)

				{  

					Score[0][k] = max(Score[0][k-1]-0.5, wordSimilarity[0][k]-0.5*(k-1) );

				}

				for(k=1;k<temp.num;k++)

				{

					for(j=1;j<libSentence[i].num;j++)

					{

						Score[k][j] = maxthree( Score[k-1][j]-0.5, Score[k][j-1]-0.5, Score[k-1][j-1]+wordSimilarity[k][j] );

					}

				}

 

				int sum = Score[temp.num-1][libSentence[i].num-1];

				

				if(saveall[testline].samenum < sum)

				{

					saveall[testline].libsent = libSentence[i].sentence;

					saveall[testline].samenum = sum;

					saveall[testline].textnum = temp.num;

					saveall[testline].textsent = temp.sentence;

				}

			}

			testline++;   //test�ļ��ľ��ӵĸ���

 

		}else  //ƥ�䵽�ո�

		{

			if( tempSentence=="" )

			{

				continue;

			}

			else if(tempSentence[tempSentence.size()==1?1:tempSentence.size()-1] != ' ') //ƥ�䵽�ո񣬵�ǰ��ĩ��Ϊ�ո���ӿո�

			{

				tempSentence += " ";

				num1 += 1;

			}

		}

    }

    infile.close();             //�ر��ļ������� 

}

 

 

float max( float a, float b )

{

	if( a > b )

		return a;

	else

		return b;

} 

 

 

float maxthree( float a, float b, float c )

{

	float temp = a;

	

	if( temp < b )

		temp = b;

	if( temp < c )

		temp = c;

	

	return temp;

} 

 

