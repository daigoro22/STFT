package sample;

/**
 * Created by abedaigorou on 16/04/10.
 */
public class SFFT extends Thread implements Runnable
{
    private final int bit=16;
    private final int hz=44100;
    private final int MONO=1;
    private final int N=1024;

    private boolean isRunning=true;
    private recorder rec=new recorder(bit,hz,MONO,N);
    private Short[] rdata=new Short[N/2];
    private FFT fft;
    private Double[] FFTData;

    @Override
    public void run() {
        while (true) {
            if (!isRunning)
                break;
            rdata = rec.getVoice();
            fft = new FFT(rdata,hz);
            FFTData = fft.getFFTData();
            System.out.println("max:" + ((double) (hz/ fft.FFTLength)) * fft.arrayMaxIndex());
        }
    }

    public Double[] getFFTData()
    {
        return FFTData;
    }

    public void Stop()
    {
        isRunning=false;
        rec.stop();
    }
}
