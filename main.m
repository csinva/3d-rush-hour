pts = [1,1,1; 2,2,2]; 
vs = 0.5; 
voxel_image(pts, vs,'yellow',.5); 
view([-37.5, 30]);
%set(gcf,'Color','black')
whitebg(gcf);
%{
Parameters:
   pts - n x 3 matrix with 3D points 
   vox_sz - scalar or 1 x 3 vector with voxel size 
   color - face color 
   alpha - face alpha (opacity) 
   edgec - edge color
%}