<?php

namespace SoftUniBlogBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class ArticleType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        // HERE WE WILL CREATE OUR FORM
        $builder
            ->add('title', TextType::class)
            ->add('content', TextType::class);
        // TectType TRQBVA DA E FormExtension ...

    }

    public function configureOptions(OptionsResolver $resolver)
    {
        // HERE WE WILL telL Our Form that IT'S TYPE IS Article
        $resolver->setDefaults(array(
           'data_class' => 'SoftUniBlogBundle\Entity\Article'
        ));
 //The default value for our resolver tells controller that is going to use the form
    }


}
