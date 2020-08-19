#include<iostream>
#include<vector>
#include<random>
#include<ctime>

using namespace std;


bool equals(vector<int> v1, vector<int> v2) {
    if (v1.size() != v2.size())
        return false;

    for (unsigned i = 0;i < v1.size();i++) {
        if (v1[i] != v2[i])
            return false;
    }
    return true;
}

vector<int> mergesortedarrays(std::vector<int> v1,std::vector<int> v2) {
    vector<int> res = v1;
    vector<int> iv = v2;

    if (v1.size() == 0) {
        return v2;
    }
    if (v2.size() == 0) {
        return v1;
    }
    if (v1[0] > v2[0]) {
        res = v2;
        iv = v1;
     }
   
    for (unsigned i = 0;i < iv.size();i++) {
        if (res[res.size()-1] <= iv[i]) {
            res.insert(res.end(), iv.begin() + i, iv.end());
            break;
      }
        for (unsigned j = 0;j < res.size()-1;j++) {
            if (iv[i] >= res[j] && iv[i] < res[j+1]) {
                res.insert(res.begin() + j+1, iv[i]);
                break;
            }
       }
    }
    return res;
}

int indexofmax(int x[], int size) {
    int max_index{};
    for (unsigned i = 0;i < size;i++) {
        if (x[i] > x[max_index]) {
            max_index = i;
        }
    }
    return max_index;
}

int indexofmax(vector<int> V) {
    int max_index{};
    for (unsigned i = 0;i < V.size();i++) {
        if (V[i] > V[max_index]) {
            max_index = i;
        }
    }
    return max_index;
}


void print(vector<int> V) {
    for (vector<int>::iterator i = V.begin();i != V.end();i++) {
        cout << *i << "\t";
    }
}

    int main(int argc, char** argv) {
        vector<int> v1;
        vector<int> v2;
        vector<int> sortedresult;

        srand(time(0));
        for (int i = 0; i < 50; i++)
        {
            v1.push_back(rand() % 10+50);
        }
        for (int i = 0; i < 30; i++)
        {
            v2.push_back(rand() % 50);
        }

        print(v1);
        cout <<"max index: " << indexofmax(v1) << " ,number" << v1[indexofmax(v1)] << endl;
        sort(v1.begin(), v1.end());
        sort(v2.begin(), v2.end());
        sortedresult.insert(sortedresult.end(), v1.begin(), v1.end());
        sortedresult.insert(sortedresult.end(), v2.begin(), v2.end());
        sort(sortedresult.begin(), sortedresult.end());
        vector<int> myFunctionResult = mergesortedarrays(v1, v2);
        cout << "\nmy function result" << endl;
        print(myFunctionResult);
        cout << "\nsort method result" << endl;
        print(sortedresult);
        cout << endl;
        std::cout << std::boolalpha;
        cout << "Test " << equals(myFunctionResult,sortedresult)<< endl;
        return 0;
    }
    




