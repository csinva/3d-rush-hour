% load parameters
% needs to somehow convey N, first thing should be escape piece
params = load('test_invalid_2.txt');
p_size = size(params);

%% parameters
N = 9; % this should reflect the number of pieces
N_2 = floor(N/2);
delay = .5;

%% graph
axis([0 N 0 N 0 N]);
xlabel('x');
ylabel('y');
zlabel('z');
whitebg(gcf);
grid;

cmap = colormap(jet(N-1));
for iter=2:p_size(1)
    cla;
    % generate escape hole at 0,N/2,N/2
    voxel([N N_2 N_2],[1 1 1],'r',1);
    pieces = params(iter,:);
    color = 1;
    % red piece
    voxel(pieces(1:3),pieces(4:6),'r',0.5);
    for i=7:6:p_size(2)
        voxel(pieces(i:i+2),pieces(i+3:i+5),cmap(color,:),0.4);
        color=color+1;
    end
    pause(delay);
end