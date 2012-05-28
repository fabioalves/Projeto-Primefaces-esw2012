using UnityEngine;
using System.Collections;

public class Projectile : MonoBehaviour
{
    public float projectileSpeed;

    public GameObject explosionPrefab;
    private Transform myTransform;

    // Use this for initialization
    void Start()
    {
        myTransform = transform;
    }

    // Update is called once per frame
    void Update() {

        float amtToMove = projectileSpeed * Time.deltaTime;

        myTransform.Translate(Vector3.up * amtToMove);

        if (myTransform.position.y >= 6.4f)
        {
            Destroy(this.gameObject);
        }
	
	}

    void OnTriggerEnter(Collider otherObject)
    {
        if (otherObject.tag == "enemy")
        {
            Enemy enemy = (Enemy)otherObject.gameObject.GetComponent("Enemy");
            Instantiate(explosionPrefab, enemy.transform.position, enemy.transform.rotation);            
            enemy.SetPositionAndSpeed();

            Destroy(gameObject);

            Player.SCORE = Player.SCORE + 100;
            if (Player.SCORE >= 1000)
                Application.LoadLevel("Win");
        }
    }
}
