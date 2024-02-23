int popcount(unsigned int x){

    int c = 0;
    for(;x!=0; x>>=1){
        if(x&1){
            c++;
        }
    }

    return c;
}