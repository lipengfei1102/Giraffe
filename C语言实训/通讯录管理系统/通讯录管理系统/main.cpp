#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define N 3
void  input(struct s_telebook *pt,int n);
void  print(struct s_telebook *pt,int n);
void search(struct s_telebook *pt,int n);
void searchbyname(struct s_telebook *pt,int n);
void searchbyphone(struct s_telebook *pt,int n);
void searchbyQQ(struct s_telebook *pt,int n);
void saverecord(struct s_telebook *pt,int n);
int  Delete(struct s_telebook tlbook[],int n);
int  insert(struct s_telebook tlbook[],int n);
void modify(struct s_telebook tlbook[] ,int n);
void modifyname(struct s_telebook tlbook[],int n,int b);
void modifyphone(struct s_telebook tlbook[],int n,int b);
void modifyQQ(struct s_telebook tlbook[],int n,int b);
void sort(struct s_telebook tlbook[],int n);
void read(struct s_telebook tlbook[],int n);
struct s_telebook
{
    int num;
    char name[10];
    char phone[12];
    char QQ[12];
}tlbook[N];
int main()
{
    struct s_telebook * pt=tlbook;
    int n=0,a=0;
    do
    {
        printf("\t\t\t  通讯录管理系统\n");
        printf("*****************************主菜单******************************\n");
        printf("* 1.input record\t\t\t2.search record\t\t*\n");
        printf("* 3.delete record\t\t\t4.insert record\t\t*\n");
        printf("* 5.modify record\t\t\t6.sort record\t\t*\n");
        printf("* 7.save record \t\t\t8.display record\t*\n");
        printf("* 9.read record\t\t\t\t0.quit system\t\t*\n");
        printf("*****************************************************************\n");
        printf("Please Enter Your Choice<0~9>:\n");
        scanf("%d",&a);
        switch(a)
        {
            case 1:
                system("cls");
                printf("请输入你要录入的人数\n");
                scanf("%d",&n);
                input(pt,n);
                system("pause");
                break;                    //录入联系人
            case 2:
                system("cls");
                search(pt,n);
                system("pause");
                break;                    //查找联系人
            case 3:
                system("cls");
                n=Delete(tlbook,n);
                system("pause");
                break;                    //删除联系人
            case 4:
                system("cls");
                n=insert(tlbook,n);
                system("pause");
                break;                    //插入联系人
            case 5:
                system("cls");
                modify(tlbook,n);
                system("pause");
                break;                    //修改联系人
            case 6:
                system("cls");
                sort(tlbook,n);
                system("pause");
                break;                    //联系人排序
            case 7:
                system("cls");
                saverecord(pt,n);
                system("pause");
                break;                    //存档联系人
            case 8:
                system("cls");
                print(pt,n);
                system("pause");
                break;                    //输出联系人
            case 9:
                system("cls");
                read(tlbook,n);
                system("pause");
                break;                    //从文档中输出到屏幕
            case 0:
                system("cls");
                system("pause");
                break;
            default:
                printf("您输入的是非法字符！");
                system("pause");
                break;
        }
    }while(a!=0);
}
//录入联系人函数定义
void  input(struct s_telebook *pt,int n)
{
    int i;
    for(i=0;i<n;i++)
    {
        printf("请输入第%d联系人的编号\n",i+1);
        scanf("%d",&pt->num);
        printf("请输入该联系人的姓名\n");
        scanf("%s",pt->name);
        getchar();
        printf("请输入该名联系人的手机号码\n");
        scanf("%s",pt->phone);
        getchar();
        printf("请输入该名联系人的QQ\n");
        scanf("%s",pt->QQ);
        pt++;
    }
    printf("录入成功！\n");
    pt=tlbook;
    print(pt,n);
}
//输出联系人函数定义
void  print(struct s_telebook *pt,int n)
{
    int i;
    printf("编号\t\t姓名\t\t手机号码\t\tQQ\n");
    for(i=0;i<n;i++)
    {
        printf("%d\t\t%s\t\t%s\t\t%s\n",pt->num,pt->name,pt->phone,pt->QQ);
        pt++;
    }
}
//查找联系人函数定义
void search(struct s_telebook *pt,int n)
{
    int a;
    printf("请输入要根据什么查找（1.姓名2手机号码3QQ）");
    scanf("%d",&a);
    switch(a)
    {
        case 1:
            searchbyname(pt,n);
            break;
        case 2:
            searchbyphone(pt,n);
            break;
        case 3:
            searchbyQQ(pt,n);
            break;
    }
}
//按姓名查找联系人函数定义
void searchbyname(struct s_telebook *pt,int n)
{
    int i;
    char b[10];
    printf("请输入您要查找的姓名");
    scanf("%s",b);
    for(i=0;i<n;i++)
    {
        if(strcmp(pt->name,b)==0)
        {
            printf("您要查找的信息是\n");
            printf("姓名：%s 编号：%d 手机号码：%s QQ:%s\n",pt->name,pt->num,pt->phone,pt->QQ);
            break;
        }
        pt++;
    }
    if(strcmp(pt->name,b)!=0)
        printf("没有找到您输入的信息！\n");
}
//按手机号码查找联系人函数定义
void searchbyphone(struct s_telebook *pt,int n)
{
    int i;
    char b[12];
    printf("请输入您要查找的手机号码");
    scanf("%s",b);
    for(i=0;i<n;i++)
    {
        if(strcmp(pt->phone,b)==0)
        {
            printf("您要查找的信息是\n");
            printf("姓名：%s 编号：%d 手机号码：%s QQ:%s\n",pt->name,pt->num,pt->phone,pt->QQ);
            break;
        }
        pt++;
    }
    if(strcmp(pt->phone,b)!=0)
        printf("没有找到您输入的信息！\n");
}
//按QQ查找联系人函数定义
void searchbyQQ(struct s_telebook *pt,int n)
{
    int i;
    char b[15];
    printf("请输入您要查找的QQ");
    scanf("%s",b);
    for(i=0;i<n;i++)
    {
        if(strcmp(pt->QQ,b)==0)
        {
            printf("您要查找的信息是\n");
            printf("姓名：%s 编号：%d 手机号码：%s QQ:%s\n",pt->name,pt->num,pt->phone,pt->QQ);
            break;
        }
        pt++;
    }
    if(strcmp(pt->QQ,b)!=0)
        printf("没有找到您输入的信息！\n");
}
//保存联系人函数定义
void saverecord(struct s_telebook *pt,int n)
{
    int i;
    FILE *fp;
    char filename[10];
    printf("请输入您要保存的文件名（eg:D\\book.txt）\n");
    scanf("%s",filename);
    if ((fp = fopen(filename,"wt")) == NULL)   //打开文件失败
    {
        printf ("无法打开这个文件\n");
    }
    fprintf(fp,"编号\t\t姓名\t\t手机号码\t\tQQ\n");
    for(i=0;i<n;i++)
    {
        fprintf(fp,"%d\t\t%s\t\t%s\t\t%s\n",pt->num,pt->name,pt->phone,pt->QQ);
        pt++;
    }
    fclose(fp);
    printf("保存成功！\n");
}
//删除联系人函数定义
int  Delete(struct s_telebook tlbook[],int n)
{
    int c,i,j;
    struct s_telebook *pt=tlbook;
    printf("请输入您要删除信息人的编号：");
    getchar();
    scanf("%d",&c);
    for(i=0;i<n;i++)
    {
        if(tlbook[i].num==c)
        {
            for(j=i;j<n;j++)
            {
                tlbook[j].num=tlbook[j+1].num;
                strcpy(tlbook[j].name,tlbook[j+1].name);
                strcpy(tlbook[j].phone,tlbook[j+1].phone);
                strcpy(tlbook[j].QQ,tlbook[j+1].QQ);
            }
            break;
        }
    }
    if(tlbook[i].num==c)
    {
        printf("没有找到您要删除的信息编号\n");
        return n;
    }
    print(pt,n-1);
    printf("删除成功！");
    return n-1;
}
//插入联系人函数定义
int insert(struct s_telebook tlbook[],int n)
{
    int d,i,j;
    struct s_telebook *pt=tlbook;
    printf("请输入您想在编号为多少的人后面插入信息\n");
    scanf("%d",&d);
    for(i=0;i<n;i++)
    {
        if(tlbook[i].num==d)
        {
            for(j=n+1;j>i;j--)
            {
                tlbook[j].num=tlbook[j-1].num;
                strcpy(tlbook[j].name,tlbook[j-1].name);
                strcpy(tlbook[j].phone,tlbook[j-1].phone);
                strcpy(tlbook[j].QQ,tlbook[j-1].QQ);
            }
            printf("请输入您要插入信息的编号\n");
            scanf("%d",&tlbook[i+1].num);
            printf("请输入该人的姓名\n");
            scanf("%s",tlbook[i+1].name);
            printf("请输入该人的手机号码\n");
            scanf("%s",tlbook[i+1].phone);
            printf("请输入该人的QQ\n");
            scanf("%s",tlbook[i+1].QQ);
            break;
        }
    }
    if(tlbook[i].num!=d)
    {
        printf("没有找到您要插入的信息编号\n");
        return n;
    }
    print(pt,n+1);
    printf("插入成功！\n");
    return n+1;
    
}
//修改联系人函数定义
void modify(struct s_telebook tlbook[],int n)
{
    int i,e,f;
    printf("请输入您要修改信息人的编号\n");
    scanf("%d",&e);
    for(i=0;i<n;i++)
    {
        if(tlbook[i].num==e)
        {
            printf("请输入您要修改的信息(1.姓名2.手机号码3.QQ)");
            scanf("%d",&f);
            switch(f)
            {
                case 1:
                    modifyname(tlbook,n,i);
                    break;
                case 2:
                    modifyphone(tlbook,n,i);
                    break;
                case 3:
                    modifyQQ(tlbook,n,i);
                    break;
            }
            break;
        }
        if(tlbook[i].num!=e)
            printf("没有找到您要修改的信息\n");
        
    }
}
//修改联系人姓名函数定义
void modifyname(struct s_telebook tlbook[],int n,int b)
{
    int i;
    char a[10];
    struct s_telebook *pt= tlbook;
    printf("请输入您修改后的姓名\n");
    scanf("%s",a);
    strcpy(tlbook[b].name,a);
    printf("修改成功！\n");
    print(pt,n);
}
//修改联系人手机号码函数定义
void modifyphone(struct s_telebook tlbook[],int n,int b)
{
    int i;
    char a[12];
    struct s_telebook *pt= tlbook;
    printf("请输入您修改后的手机号码\n");
    scanf("%s",a);
    strcpy(tlbook[b].phone,a);
    printf("修改成功！\n");
    print(pt,n);
}
//修改联系人QQ函数定义
void modifyQQ(struct s_telebook tlbook[],int n,int b)
{
    int i;
    char a[15];
    struct s_telebook *pt= tlbook;
    printf("请输入您修改后的QQ\n");
    scanf("%s",a);
    strcpy(tlbook[b].QQ,a);
    printf("修改成功！\n");
    print(pt,n);
}
//联系人排序函数定义
void sort(struct s_telebook tlbook[],int n)
{
    int b,i,j,k,temp;
    char temp1[10];
    struct s_telebook *pt=tlbook;
    printf("请输入你要根据什么信息排序(1.编号2.姓名)\n");
    scanf("%d",&b);
    if(b==1)
    {
        for(i=0;i<n-1;i++)
        {
            k=i;
            for(j=i+1;j<n;j++)
            {
                if(tlbook[j].num<tlbook[k].num)
                    k=j;
            }
            if(k!=i)
            {
                temp=tlbook[k].num;
                tlbook[k].num=tlbook[i].num;
                tlbook[i].num=temp;
                
            }
        }
        
        print(pt,n);
    }
    else if(b==2)
    {
        for(i=0;i<n-1;i++)
        {
            k=i;
            for(j=i+1;j<n;j++)
            {
                if(strcmp(tlbook[j].name,tlbook[k].name)>0)
                    k=j;
            }
            if(k!=i)
            {
                strcpy(temp1,tlbook[k].name);
                strcpy(tlbook[k].name,tlbook[i].name);
                strcpy(tlbook[i].name,temp1);
                
            }
        }
        
        print(pt,n);
    }
    else
    {
        printf("输入错误！\n");
    }
    
}
//读取联系人函数定义
void read(struct s_telebook tlbook[],int n)
{
    int i;
    FILE *fp;
    char ch;
    char filename[10];
    struct s_telebook *pt=tlbook;
    printf("请输入您要打开的文件名（eg:D\\book.txt）\n");
    scanf("%s",filename);
    if ((fp = fopen(filename,"rt")) == NULL)   //打开文件失败
    {
        printf ("无法打开这个文件\n");
    }
    while((ch=fgetc(fp))!=EOF)
    {
        printf("%c",ch);
    }
    fclose(fp);
    
}
