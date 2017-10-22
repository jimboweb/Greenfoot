import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClassMarker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClassMarker extends BuildTools
{
    WorldBuilder myWorld;
    MouseInfo mi;
    Class selectedClass;
    Actor template;
    int scale=2;
    public ClassMarker(WorldBuilder myWorld, Class selectedClass)
    {
        this.myWorld = myWorld;
        this.selectedClass = selectedClass;
        setImageToSelected(selectedClass);
        myWorld.addObject(this, 0, 0);
    }

    public void act() 
    {
        if(scale!=myWorld.getScale())
        {
            scale = myWorld.getScale();
            String actorClassName = selectedClass.toString().split("class ")[1];

            try {
                Actor proto = (Actor)Class.forName(actorClassName).newInstance();          
                GreenfootImage protoImage = proto.getImage();
                protoImage.scale((int)protoImage.getHeight()/scale, (int)protoImage.getWidth()/scale);
                setImage(protoImage);

            } catch (ClassNotFoundException e) {
                System.out.println(e);
            } catch (InstantiationException e) {
                System.out.println(e);
            }catch (IllegalAccessException e) {
                System.out.println(e);
            }                        
        }
        if(Greenfoot.isKeyDown("shift"))
        {
            mi = Greenfoot.getMouseInfo();
            setLocation(mi.getX(), mi.getY());
            Class selectedInWorld = myWorld.selectedClass();
            if(!selectedClass.equals(selectedInWorld))
            {
                selectedClass = selectedInWorld;
                setImageToSelected(selectedClass);
            }
            if(Greenfoot.mouseClicked(this))
            {

                try{
                    Actor newActor = (Actor)selectedClass.newInstance();
                    GreenfootImage img = newActor.getImage();
                    img.scale(img.getWidth()/scale, img.getHeight()/scale);
                    myWorld.addObject(newActor, getX(), getY());
                    myWorld.addActorsInGame(newActor);
                }catch(InstantiationException e)
                {
                    System.out.println(e);
                } catch(IllegalAccessException e)
                {
                    System.out.println(e);
                }  finally {
                }
            }
        } else{
            setLocation(0, 0);
        }
    }    

    private void setImageToSelected(Class c)
    {
        try {
            this.template = (Actor)c.newInstance();
        }catch(InstantiationException e)
        {
            System.out.println(e);
        } catch(IllegalAccessException e)
        {
            System.out.println(e);
        }  finally {
            GreenfootImage myImage = template.getImage();
            myImage.scale(myImage.getWidth()/scale, myImage.getHeight()/scale);
            setImage(myImage);
        }
    }
}
