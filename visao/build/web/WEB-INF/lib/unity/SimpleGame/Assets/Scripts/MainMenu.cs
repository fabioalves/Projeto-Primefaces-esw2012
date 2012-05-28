using UnityEngine;
using System.Collections;

public class MainMenu : MonoBehaviour
{
    public Texture backgroundTexture;
    private string instructionText = "Instruções: "+
        "\nUse as setas do teclado para se mover. "+
        "\nAperte o botão 'espaço' para atirar";

    private int buttonWidth = 200;
    private int buttonHeight = 50;

    void OnGUI()
    {
        GUI.DrawTexture(new Rect(0, 0, Screen.width, Screen.height), backgroundTexture);
        GUI.Label(new Rect(10, 10,400, 400), instructionText);

        //if (Input.anyKeyDown)
        //{
        //    Application.LoadLevel("Level1");
        //}

        if (GUI.Button(new Rect(Screen.width / 2 - buttonWidth / 2,
                            Screen.height / 2 - buttonHeight / 2,
                            buttonWidth, buttonHeight),
                       "Iniciar"))
        {
            Application.LoadLevel("Level1");
        }
    }
}
