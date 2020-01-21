import re
import numpy as np

def load(txt):
    word_list = list(filter(None, re.split(r"[\n|\s|,|!|.|'|?|:|\"|(|)]", open(txt).read())))
    word_list = [s.lower() for s in word_list if isinstance(s, str) == True]
    number_list = []
    for i in word_list:
        k = word_list.count(i)
        number_list.append(k)
    if len(word_list) == len(number_list):
        array = np.array([word_list, number_list])
        array = np.transpose(array)
        array = np.array(list(set([tuple(t) for t in array])))
        # print(array)
        print('加载文章成功')
        return array
    else:
        print("load error")
    return -1


def partition(arr1, low, high):
    i = (low - 1)  # 最小元素索引
    pivot = arr1[high]
    for j in range(low, high):
        # 当前元素小于或等于 pivot
        if arr1[j] <= pivot:
            i = i + 1
            arr1[i], arr1[j] = arr1[j], arr1[i]
            arr0[i], arr0[j] = arr0[j], arr0[i]
    arr1[i + 1], arr1[high] = arr1[high], arr1[i + 1]
    arr0[i + 1], arr0[high] = arr0[high], arr0[i + 1]
    return (i + 1)
# arr[] --> 排序数组
# low  --> 起始索引
# high  --> 结束索引
# 快速排序函数
def quickSort(arr1, low, high):
    if low < high:
        pi = partition(arr1, low, high)
        quickSort(arr1, low, pi - 1)
        quickSort(arr1, pi + 1, high)

def show1(arr):
    print("按频率排序:")
    m,n = np.shape(arr)
    ls1= arr[:,0]
    ls2= arr[:,1]
    for i in range(m):
        k = m - i - 1
        if (ls1[k] == 'a')|(ls1[k] == 'and')|(ls1[k] == 'of')|(ls1[k] == 'algorithms'):
            print('{:>30}{:>20}'.format(ls1[k], ls2[k]))
    for i in range(m):
        k = m-i-1
        if (ls1[k] == 'a')|(ls1[k] == 'and')|(ls1[k] == 'of')|(ls1[k] == 'algorithms'):
            continue
        print('{:>30}{:>20}'.format(ls1[k], ls2[k]))

def show2(arr):
    print("按字母顺序排序:")
    ls1= arr[:,0]
    ls2= np.intc(arr[:,1])
    d = dict(zip(ls1,ls2))
    for k in sorted(d):
        print('{:>30}{:>20}' .format(k, d[k]))

if __name__ == '__main__':
    txt = 'text.txt'
    arr = load(txt)
    arr1 = (arr[:,1])
    global arr0
    arr0 = arr[:,0]
    n = len(arr1)
    quickSort(arr1, 0, n - 1)
    print("\n")
    show1(arr)
    print("\n")
    show2(arr)
