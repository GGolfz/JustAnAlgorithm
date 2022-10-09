#include <cstdio>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
const int maxN = 10005,INF = (int)1e9;
class graph{
public:
	int v,dist;
	graph(int v,int dist){
		this->v = v;
		this->dist = dist;
	}
};
//compare function (min heap sort by dist from source to that node)
class cmp{
public:
	bool operator()(graph& left,graph& right){
		return left.dist > right.dist;	
	}
};
vector<graph> vec[maxN];
int dist[maxN];
int main(){
	int n,m,u,v,w,s,e;
	scanf("%d %d %d %d",&n,&m,&s,&e);
	//we collect the grapg in adjacency list
	for(int i=0;i<m;i++){
		scanf("%d %d %d",&u,&v,&w);
		vec[u].push_back(graph(v,w));
		vec[v].push_back(graph(u,w));
	}
	//dist from source to every nodes are all INF
	for(int i=0;i<n;i++){
		dist[i] = INF;
	}
	//dist from source to source is 0
	dist[s] = 0;
	//we use pq to store the current node and dist from source to current node
	//pq must be min heap
	priority_queue<graph,vector<graph>,cmp> pq;
	pq.push(graph(s,0));
	while(!pq.empty()){
		//extract the min dist from pq
		int u = pq.top().v;
		pq.pop();
		for(int i=0;i<vec[u].size();i++){
			int v = vec[u][i].v;
			int w = vec[u][i].dist;
			int newWeight = w+dist[u];
			//if dist from node u (ccurrent node) plus by the weight of edge is less than
			//dist in node v (dist[v]), that means we can edit the distance
			if(newWeight < dist[v]){
				//change the distance and push into pq
				dist[v] = newWeight;
				pq.push(graph(v,newWeight));
			}
		}
	}
	printf("%d\n",dist[e]);
	return 0;
}
/*
9 14 0 8
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