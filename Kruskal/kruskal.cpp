#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;
class graph{
public:
	int u,v,w;
	graph(int u,int v,int w){
		this->u = u;
		this->v = v;
		this->w = w;
	}
};
bool cmp(graph& left,graph& right){
	return left.w < right.w;
}
const int maxN = 10001;
vector<graph> vec;
int parent[maxN];
int root(int u){
	//if we already found the representative node, can return that node
	if(u == parent[u]) return u;
	//find the representative node by passing the parent of that node
	//and assign to its parent to reduce time
	return parent[u] = root(parent[u]);
}
bool merge(int u,int v){
	//find representative of node u and node v
	u = root(u);
	v = root(v);
	//u and v are already in the same group, do not merge
	if(u == v) return false;
	//meger group u into group v
	parent[u] = v;
	return true;
}
int main(){
	int n,m,u,v,w;
	scanf("%d %d",&n,&m);
	for(int i=0;i<m;i++){
		scanf("%d %d %d",&u,&v,&w);
		vec.push_back(graph(u,v,w));
	}
	//sort by edges from min t max
	sort(vec.begin(),vec.end(),cmp);
	int idx = 0,cnt = 0,sum = 0;
	//at first, every node are disconnected, so the parent of each node is itself
	for(int i=0;i<n;i++){
		parent[i] = i;
	}
	//build a tree by chossing the n-1 edges
	while(cnt < n-1){
		int u = vec[idx].u,v = vec[idx].v,w = vec[idx].w;
		bool can_merge = merge(u,v);
		if(can_merge){
			cnt++;
			sum+=w;
			printf("choose node %d %d weight %d\n",u,v,w);
		}
		idx++;
	}
	printf("%d\n",sum);
	return 0;
}
/*
9 14
0 1 4
0 7 8
1 7 11
1 2 8
2 3 7
3 4 9
4 5 10
6 5 2
7 6 1
7 8 7
2 8 2
2 5 4
3 5 14
8 6 6
*/