using UnityEngine;
using System.Collections;

public class Win : MonoBehaviour
{
    public Texture backgroundTexture;
    private int buttonWidth = 200;
    private int buttonHeight = 50;

    void OnGUI()
    {
        GUI.DrawTexture(new Rect(0, 0, Screen.width, Screen.height), backgroundTexture);
        GUI.Label(new Rect(10, 10, 400, 400), "Você venceu");
        if (GUI.Button(new Rect(Screen.width / 2 - buttonWidth / 2,
                            Screen.height / 2 - buttonHeight / 2,
                            buttonWidth, buttonHeight),
                       "Aperte para Reiniciar"))
        {
            Player.LIVES = 3;
            Player.SCORE = 0;
            Player.MISSED = 0;
            Application.LoadLevel("Level1");
        }
    }
}
