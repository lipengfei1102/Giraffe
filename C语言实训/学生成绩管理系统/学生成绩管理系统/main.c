#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct Student//学生结构
{
    char num[10];//学号
    char name [15];//姓名
    int cgrade;//C语言成绩
    int mgrade;//数学成绩
    int egrade;//英语成绩
    int tolal;//总成绩
    float ave;//平均成绩
    int mingci;//排名
};
typedef struct JD//结点
{
    struct Student st;//数据域`
    struct JD *pnext;//指针域
}P1, *P2;
P2 Input(void);//输入
void Display(P2 phead);//输出
void Delete(P2 phead);//删除
void Search(P2 phead);//查找
void Modify(P2 phead);//修改
void Insert(P2 phead);//增加学
void CountByC(P2 phead);//C语言成绩排序
void CountByM(P2 phead);//数学成绩排序
void CountByE(P2 phead);//英语成绩排序
void SortByTolal(P2 phead);//总分排序
void SortByC(P2 phead);
void SortByM(P2 phead);
void SortByE(P2 phead);
void save(P2 phead);//保存文件
int main()
{
    printf("\n\t\t\tSelect the command to operate：\t\t\t\n\n");
    printf("\t\t\t 1  Input record\n\n");
    printf("\t\t\t 2  Delete record\n\n");
    printf("\t\t\t 3  Search recore\n\n");
    printf("\t\t\t 4  Modify record\n\n");
    printf("\t\t\t 5  Insert record\n\n");
    printf("\t\t\t 6  Count record\n\n");
    printf("\t\t\t 7  Sort record\n\n");
    printf("\t\t\t 8  Save record\n\n");
    printf("\t\t\t 9  Display record\n\n");
    printf("\t\t\t 0  Quit system record\n\n");
    int m;//保存操作命令
    P2 phead = NULL;//定义一个指针
    while(1)
    {
        printf("Select the command to operate:");
        scanf("%d",&m);
        switch(m)
        {
            case 1://输入
            {
                phead = Input();
            }
                break;
            case 2://删除
            {
                Delete(phead);
            }
                break;
            case 3://查找
            {
                Search(phead);
            }
                break;
            case 4://修改
            {
                Modify(phead);
            }
                break;
            case 5://增加
            {
                Insert(phead);
            }
                break;
            case 6://统计各科
            {
                CountByC(phead);
                CountByM(phead);
                CountByE(phead);
               
            }
                break;
            case 7://对学生的总分排序
            {
                SortByTolal(phead);
                Display(phead);
                SortByC(phead);
                Display(phead);
                SortByM(phead);
                Display(phead);
                SortByE(phead);
                Display(phead);
                printf("\n Nice\n\n");
            }
                break;
            case 8://保存文件
            {
                save(phead);
            }
                break;
            case 9://输出
            {
                Display(phead);
            }
                break;
            case 0:
            {
                exit(0);
            }
        }
    }
}
P2 Input(void)//输入函数,用于输入
{
    int len;//
    P1 stu;//
    P2 phead = (P2)malloc(sizeof(P1));
    if(NULL == phead)
    {
        printf("Fail!\n");
        
        exit(-1);
    }
    P2 pTail=phead;//
    pTail->pnext = NULL;//清空指针域
    printf("student number:");
    scanf("%d",&len);
    int i=0;
    for(i=0; i<len; i++)
    {
        stu.st.mingci=i+1;
        printf("the %ded student num name cgrade mgrade egrade\n", stu.st.mingci);
        scanf("%s", stu.st.num);
        scanf("%s", stu.st.name);
        scanf("%d", &stu.st.cgrade);
        scanf("%d", &stu.st.mgrade);
        scanf("%d", &stu.st.egrade);
        stu.st.tolal = stu.st.cgrade + stu.st.mgrade + stu.st.egrade;
        stu.st.ave =(float)stu.st.tolal/3;
        P2 pnew = (P2)malloc(sizeof(P1));//为新节点分配内存
        if(NULL == pnew) //判断内存是否为空
        {
            printf("Fail!\n");
            exit(-1);
        }
        pnew->st = stu.st; //初始化结点的数据域
        pTail->pnext = pnew;//将新结点挂到老结点后
        pnew->pnext = NULL;//清空新结点的指针域
        pTail = pnew;
    }
    printf("\n Nice\n\n");
    return phead;
}
void Display(P2 phead)//输出
{
    P2 p = phead->pnext;//一个指针
    int i=1;
    while(NULL != p)
    {
        printf("num=%s\t",p->st.num);
        printf("name=%s\t",p->st.name);
        printf("cgrade=%d\t",p->st.cgrade);
        printf("mgrade=%d\t",p->st.mgrade);
        printf("egrade=%d\t",p->st.egrade);
        printf("tolal=%d\t",p->st.tolal);
        printf("\tave=%f\t",p->st.ave);
        printf("mingci=%d\t",i);
        i++;
        printf("\n");
        p = p->pnext;
    }
}
void Delete(P2 phead)//删除
{
    P2 p = phead;
    int i = 0;
    int ilndex;
    printf("Input the student number you want to delete:");
    scanf("%d",&ilndex);
    while(NULL != p->pnext && i<ilndex-1)
    {
        p = p->pnext;
        i++;
    }
    if(NULL == p->pnext || i>ilndex-1)
    {
        printf("Not find the student number !\n");
        return;
    }
    P2 q = p->pnext;
    p->pnext = q->pnext;
    free(q);
    q = NULL;
    printf("You have delete the%ded student !\n",ilndex);
}
void Search(P2 phead)//查找
{
    char N[10];
    printf("Input the student name or num you want to search :");
    scanf("%s",N);
    P2 p = phead->pnext;
    while(NULL != p)
    {
        if(0 == strcmp(N,p->st.name)||0==strcmp(N,p->st.num))
        {
            printf("num=%s\n",p->st.num);
            printf("name=%s\n",p->st.name);
            printf("cgrade=%d\n",p->st.cgrade);
            printf("mgrade=%d\n",p->st.mgrade);
            printf("egrade=%d\n",p->st.egrade);
            printf("tilal=%d\n",p->st.tolal);
            printf("ave=%f\n",p->st.ave);
        }
        p = p->pnext;
    }
}
void Modify(P2 phead)//修改
{
    char Name[10];
    printf("Input the student name you want to modify:");
    scanf("%s",Name);
    P2 p = phead->pnext;//定义一个指针用于遍历
    while(NULL != p)
    {
        if(0 == strcmp(Name, p->st.name))
        {
            printf("Student information before modification!\n");
            printf("num=%s\n",p->st.num);
            printf("name=%s\n",p->st.name);
            printf("cgrade=%d\n",p->st.cgrade);
            printf("mgrade=%d\n",p->st.mgrade);
            printf("egrade=%d\n",p->st.egrade);
            printf("tilal=%d\n",p->st.tolal);
            printf("ave=%f\n",p->st.ave);
            
            printf("The new num:\t");
            printf("The new name:\t");
            printf("The new cgrade:\t");
            printf("The new mgrade:\t");
            printf("The new egrade:\n");
            scanf("%s", p->st.num);
            scanf("%s", p->st.name);
            scanf("%d", &p->st.cgrade);
            scanf("%d", &p->st.mgrade);
            scanf("%df", &p->st.egrade);
            p->st.tolal=p->st.cgrade+p->st.mgrade+p->st.egrade;
            p->st.ave=(float)p->st.tolal/3;
            break;
        }
        p = p->pnext;
    }
}
void Insert(P2 phead)//增加
{
    P2 p = phead;
    int i = 0;
    struct Student stu;//学生结构
    int pos;//插入结点的位置
    printf("Choose the location you want to insert:");
    scanf("%d",&pos);
    while(NULL != p && i<pos-1)
    {
        p = p->pnext;
        i++;
    }
    if(NULL == p || i>pos)
    {
        printf("Not find!\n");
        return;
    }
    printf("You will insert a student behind the %ded student\n",pos-1);
    printf("the %ded student numbe name cgrade mgrade egrader:\n",pos);
    scanf("%s",stu.num);
    scanf("%s",stu.name);
    scanf("%d",&stu.cgrade);
    scanf("%d",&stu.mgrade);
    scanf("%d",&stu.egrade);
    stu.tolal = stu.cgrade + stu.mgrade +stu.egrade;
    stu.ave = (float )stu.tolal/3;
    P2 pnew = (P2)malloc(sizeof(P1));
    
    if(NULL == pnew)
    {
        printf("Fail!\n");
        
        exit(-1);
    }
    
    pnew->st = stu;
    P2 q = p->pnext;
    p->pnext = pnew;
    pnew->pnext = q;
    printf("\n Nice\n\n");
}
void CountByC(P2 phead)//对学生的C语言成绩统计
{
    P2 p, q;//定义两个指针
    P1 temp;
    int count=0;
    for(p=phead->pnext; NULL != p; p=p->pnext)
    {
        for(q=p->pnext; NULL !=q; q=q->pnext)
        {
            if(p->st.cgrade< q->st.cgrade)//当前一个学生的成绩小于后一个学生的成绩时
            {
                temp.st.cgrade  = p->st.cgrade;//交换学生的位置
                p->st.cgrade =  q->st.cgrade;
                q->st.cgrade = temp.st.cgrade;
            }
            if(p->st.cgrade<60)
            {
                count++;
            }
        }
    }
    printf("the number of people that cgrade less than 60:%d\n",count);
    printf("the highest cgrade is:\n");
    P2 pp = phead->pnext;//一个指针
    while(NULL != pp)
    {
        printf("cgrade=%d\t",pp->st.cgrade);
        pp = pp->pnext;
    }
    printf("\n\n");
    printf("\n Nice\n\n");
}

//对学生的数学成绩排序
void CountByM(P2 phead)
{
    P2 p, q;//定义两个指针
    
    P1 temp;
    int count=0;
    for(p=phead->pnext; NULL != p; p=p->pnext)
    {
        for(q=p->pnext; NULL !=q; q=q->pnext)
        {
            if(p->st.mgrade < q->st.mgrade)
            {
                temp.st.mgrade  = p->st.mgrade;//交换学生的位置
                p->st.mgrade =  q->st.mgrade;
                q->st.mgrade = temp.st.mgrade;
            }
            if(p->st.mgrade<60)
            {
                count++;
            }
        }
    }
    printf("the number of people that mgrade less than 60:%d\n",count);
    printf("the highest mgrade is:\n");
    P2 pp = phead->pnext;//一个指针
    while(NULL != pp)
    {
        printf("mgrade=%d\t",pp->st.mgrade);
        pp = pp->pnext;
    }
    printf("\n\n");
    printf("\n Nice\n\n");
}
void CountByE(P2 phead)//对学生的英语成绩排序
{
    P2 p, q;//定义两个指针
    P1 temp;
    int count=0;
    for(p=phead->pnext; NULL != p; p=p->pnext)
    {
        for(q=p->pnext; NULL !=q; q=q->pnext)
        {
            if(p->st.egrade< q->st.egrade)//当前一个学生的英语成绩小于后一个学生的英语成绩时
            {
                temp.st.egrade  = p->st.egrade;//交换学生的位置
                p->st.egrade =  q->st.egrade;
                q->st.egrade = temp.st.egrade;
            }
            if(p->st.egrade<60)
            {
                count++;
            }
        }
    }
    printf("the number of people that egrade less than 60:%d\n",count);
    printf("the highest egrade is:\n");
    P2 pp = phead->pnext;//一个指针
    while(NULL != pp)
    {
        printf("egrade=%d\t",pp->st.egrade);
        pp = pp->pnext;
    }
     printf("\n\n");
    printf("\n Nice\n\n");
}
void SortByTolal(P2 phead)//对学生的总分排序
{
    printf("\nSortByTolal:\n");
    P2 p, q;//定义两个指针
    P1 temp;
    for(p=phead->pnext; NULL != p; p=p->pnext)
    {
        for(q=p->pnext; NULL !=q; q=q->pnext)
        {
            if(p->st.tolal < q->st.tolal)//当前一个学生的总分小于后一个学生的总分时
            {
                temp.st  = p->st;
                p->st =  q->st;
                q->st = temp.st;
            }
        }
    }
}
void SortByC(P2 phead)//对学生的C语言成绩排序
{
    printf("\nSortByC:\n");
    P2 p, q;//定义两个指针
    P1 temp;
    for(p=phead->pnext; NULL != p; p=p->pnext)
    {
        for(q=p->pnext; NULL !=q; q=q->pnext)
        {
            if(p->st.cgrade< q->st.cgrade)//当前一个学生的成绩小于后一个学生的语文成绩时
            {
                temp.st  = p->st;//交换学生的位置
                p->st =  q->st;
                q->st = temp.st;
            }
        }
    }
}
void SortByM(P2 phead)//对学生的C语言成绩排序
{
    printf("\nSortByM:\n");
    P2 p, q;//定义两个指针
    P1 temp;
    for(p=phead->pnext; NULL != p; p=p->pnext)
    {
        for(q=p->pnext; NULL !=q; q=q->pnext)
        {
            if(p->st.mgrade< q->st.mgrade)//当前一个学生的成绩小于后一个学生的语文成绩时
            {
                temp.st  = p->st;//交换学生的位置
                p->st =  q->st;
                q->st = temp.st;
            }
        }
    }
}
void SortByE(P2 phead)//对学生的C语言成绩排序
{
    printf("SortByE:\n");
    P2 p, q;//定义两个指针
    P1 temp;
    for(p=phead->pnext; NULL != p; p=p->pnext)
    {
        for(q=p->pnext; NULL !=q; q=q->pnext)
        {
            if(p->st.egrade< q->st.egrade)//当前一个学生的成绩小于后一个学生的语文成绩时
            {
                temp.st  = p->st;//交换学生的位置
                p->st =  q->st;
                q->st = temp.st;
            }
        }
    }
}
void save(P2 phead)
{
    FILE *fp;
    if((fp=fopen("student","wb+"))==NULL)
    {
        printf("FAILURE\n");
        exit(0);
    }
    P2 p = phead->pnext;
    while(NULL != p)
    {
        fprintf(fp,"%s",p->st.num);
        fprintf(fp,"%s",p->st.name);
        fprintf(fp,"%d",p->st.cgrade);
        fprintf(fp,"%d",p->st.mgrade);
        fprintf(fp,"%d",p->st.egrade);
        fprintf(fp,"%d",p->st.tolal);
        fprintf(fp,"%f",p->st.ave);
        fprintf(fp,"%d",p->st.mingci);
        printf("\n");
        p = p->pnext;
    }
    fclose(fp);
    printf("Nice!");
}
