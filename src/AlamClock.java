import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class AlamClock implements Runnable{

    private  final LocalTime alarmTime;
    private final String filepath;
    AlamClock (LocalTime alarmTime, String filepath){
        this.alarmTime=alarmTime;
        this.filepath=filepath;
    }
    @Override
    public void run(){


        while (LocalTime.now().isBefore(alarmTime)){
            try {
                Thread.sleep(1000);
                LocalTime now = LocalTime.now();

                System.out.printf("\r%02d:%02d:%02d", now.getHour(),
                                                   now.getMinute(),
                                                   now.getSecond());
            } catch (InterruptedException e) {
                System.out.println("Thtead was interrrupted");
            }
        }
        System.out.printf("\nAlam Rings!!!!!");
       playSound(filepath);
    }
    private void playSound(String filepath) {
        File audioFile = new File(this.filepath);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();


        } catch (UnsupportedAudioFileException e) {
            System.out.println("audio file format not supported");
        } catch (LineUnavailableException e) {
            System.out.println("audio unavailable!");
        } catch (IOException e) {
            System.out.println("something went wrong !");
        }

    }
}
