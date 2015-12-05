N = 5;
N_2 = floor(N/2);

% generate escape hole at 0,N/2,N/2
voxel([N N_2 N_2],[1 1 1],'cyan',0.5);

% generate escaping piece
voxel([0 N_2 N_2],[2 1 1],'cyan',0.5);

% generate pieces


voxel([2 3 4],[1 1 1],'g',0.5); % voxel(start,size,color,alpha);
axis([0 N 0 N 0 N]);
xlabel('x');
ylabel('y');
zlabel('z');
whitebg(gcf);
grid;
 