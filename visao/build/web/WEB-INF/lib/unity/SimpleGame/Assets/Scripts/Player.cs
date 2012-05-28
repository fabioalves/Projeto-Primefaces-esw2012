using UnityEngine;
using System.Collections;

public class Player : MonoBehaviour
{
    public float playerSpeed;

    public GameObject ProjectilePrefab;
    public GameObject explosionPrefab;

    private Transform myTransform;



    public static int SCORE = 0;
    public static int LIVES = 3;
    public static int MISSED = 0;

    // Use this for initialization
    void Start()
    {
        myTransform = transform;
    }

    // Update is called once per frame
    void Update()
    {
        //quanto se move
        float amtToMove = Input.GetAxisRaw("Horizontal") * playerSpeed * Time.deltaTime;

        //move o jogador
        myTransform.Translate(Vector3.right * amtToMove);

        
        //atravessar tela
        if (myTransform.position.x <= -7.5f) 
        {
            myTransform.position = new Vector3(7.4f, transform.position.y, transform.position.z);
        }
        else if (myTransform.position.x >= 7.5f)
        {
            myTransform.position = new Vector3(-7.4f, transform.position.y, transform.position.z);
        }

        if (Input.GetKeyDown("space"))
        {
            //atirar
            Instantiate(
                ProjectilePrefab, 
                new Vector3(myTransform.position.x, 
                            myTransform.position.y + (myTransform.localScale.y / 2), 
                            myTransform.position.z), 
                Quaternion.identity);
        }

       

        
    }

    void OnGUI()
    {
        GUI.Label(new Rect(10, 10, 120, 40), "Pontos: " + Player.SCORE.ToString());
        GUI.Label(new Rect(10, 30, 60, 20), "Vidas: " + Player.LIVES.ToString());        
        GUI.Label(new Rect(10, 50, 120, 20), "Perdidos: " + Player.MISSED.ToString());
    }

    void OnTriggerEnter(Collider otherObject)
    {
        if (otherObject.tag == "enemy")
        {
            Player.LIVES--;

            Enemy enemy = (Enemy)otherObject.gameObject.GetComponent("Enemy");            
            enemy.SetPositionAndSpeed();

            StartCoroutine(DestroyShip());
        }
    }

    IEnumerator DestroyShip()
    {
        Instantiate(explosionPrefab, myTransform.position, myTransform.rotation);
        gameObject.renderer.enabled = false;

        transform.position = new Vector3(0f, myTransform.position.y, myTransform.position.z);
        yield return new WaitForSeconds(1.5f);

        if (Player.LIVES > 0)
            gameObject.renderer.enabled = true;
        else
            Application.LoadLevel("Lose");

    }
  
}
