#include <cstdio>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
const int maxN = 10001, INF = (int)1e9;
int dist[maxN];
bool visited[maxN];
class graph{
public:
	int v,w;
	graph(int v,int w){
		this->v = v;
		this->w = w;
	}
};
class cmp{
public:
	bool operator()(graph& left, graph& right){
		return left.w > right.w;
	}
};
vector<graph> vec[maxN];
int main(){
	int n,m,u,v,w;
	scanf("%d %d",&n,&m);
	for(int i=0;i<m;i++){
		scanf("%d %d %d",&u,&v,&w);
		vec[u].push_back(graph(v,w));
		vec[v].push_back(graph(u,w));
	}
	for(int i=0;i<n;i++){
		dist[i] = INF;
	}
	int start = 0,sum = 0;
	dist[start] = 0;
	priority_queue<graph,vector<graph>,cmp> pq;
	pq.push(graph(start,dist[start]));
	while(!pq.empty()){
		int u = pq.top().v, d = pq.top().w;
		pq.pop();
		if(visited[u]) continue;
		printf("choose node %d weight = %d\n",u,d);
		visited[u] = true;
		sum+=dist[u];
		for(int i=0;i<vec[u].size();i++){
			int v = vec[u][i].v,w = vec[u][i].w;
			if(visited[v] == false && w < dist[v]){
				dist[v] = w;
				pq.push(graph(v,dist[v]));
			}
		}
	}
	printf("%d\n",sum);
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