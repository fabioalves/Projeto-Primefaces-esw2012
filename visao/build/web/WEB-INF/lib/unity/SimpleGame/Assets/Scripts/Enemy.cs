using UnityEngine;
using System.Collections;

public class Enemy : MonoBehaviour
{
    public float minSpeed;
    public float maxSpeed;

    private float currentSpeed;

    private float x, y, z;

    private Transform myTransform;

    // Use this for initialization
    void Start()
    {
        myTransform = transform;
        SetPositionAndSpeed();
    }

    // Update is called once per frame
    void Update()
    {
        float amtToMove = currentSpeed * Time.deltaTime;
        myTransform.Translate(Vector3.down * amtToMove);


        if (myTransform.position.y <= -5f)
        {
            SetPositionAndSpeed();
            Player.MISSED++;
        }

    }

    public void SetPositionAndSpeed()
    {
        currentSpeed = Random.Range(minSpeed, maxSpeed);

        y = 7.0f;
        x = Random.Range(-6f, 6f);
        z = 0.0f;

        myTransform.position = new Vector3(x, y, z);
    }
}
