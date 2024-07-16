#version 150

#moj_import <matrix.glsl>

uniform sampler2D Sampler0;
uniform sampler2D Sampler1;

uniform float GameTime;

in vec4 texProj0;
in vec3 Position;

out vec4 fragColor;

vec3 palette( float t ) {
    vec3 a = vec3(0.5, 0.5, 0.5);
    vec3 b = vec3(0.5, 0.5, 0.5);
    vec3 c = vec3(1.0, 1.0, 1.0);
    vec3 d = vec3(0.263,0.416,0.557);

    return a + b*cos( 6.28318*(c*t+d) );
}


void main() {

    vec3 col = 0.5 + 0.5*cos( GameTime * 2400 + Position.xyx + vec3(0,2,4));

    fragColor = vec4(col, 1.0);


}