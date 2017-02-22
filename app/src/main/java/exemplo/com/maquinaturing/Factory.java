package exemplo.com.maquinaturing;

import android.content.Context;

import exemplo.com.maquinaturing.old.GetPostUrlFuncaoTransicaoDao;

public class Factory {
    public static FuncaoTransicaoDao createFuncaoTransicaoDao(){
        return new GetPostUrlFuncaoTransicaoDao();
    }
    public static MaquinaTuringDao createMaquinaTuringDao(Context context){
        return new SqliteMaquinaTuringDao(context);
    }

}
